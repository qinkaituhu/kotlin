package test

inline fun <T, R> with(receiver: T, block: T.() -> R): R = receiver.block()

class A {
    class B {
        class X {

        }

        companion object {
            class Y

            fun foo(n: Int) {}

            val bar = 1

            fun Int.extFoo(n: Int) {}

            val Int.extBar: Int get() = 1
        }

        object O {
            class Y

            fun foo(n: Int) {}

            val bar = 1

            fun Int.extFoo(n: Int) {}

            val Int.extBar: Int get() = 1
        }

    }

    class C {
        fun test() {
            B.X()

            B.Companion.Y()
            B.foo(B.bar)
            //1.extFoo(1.extBar) // conflict

            B.O.Y()
            B.O.foo(B.O.bar)

            with (B.O) {
                B.Companion.Y()
                foo(bar)
                1.extFoo(1.extBar)
            }
        }
    }
}