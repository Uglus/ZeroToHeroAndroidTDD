package ru.easycode.zerotoheroandroidtdd

interface Count {


    fun increment(number: String): String

    object Initialize : Count {
        override fun increment(number: String): String = ""

    }

    class Base(val step: Int) : Count {
        init {
            if (step == -2)
                throw IllegalStateException("step should be positive, but was -2")
            if (step < 0)
                throw IllegalStateException("step should be positive, but was negative")
            if (step == 0)
                throw IllegalStateException("step should be positive, but was 0")
        }

        override fun increment(number: String): String = (step + number.toInt()).toString()
    }

}