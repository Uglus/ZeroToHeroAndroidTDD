package ru.easycode.zerotoheroandroidtdd

interface Count {

    fun initial(number: String): UiState

    fun increment(number: String): UiState

    fun decrement(number: String): UiState

    class Base(private val step: Int, private val max: Int, private val min: Int) : Count {

        init {
            if (step < 1)
                throw IllegalStateException("step should be positive, but was $step")

            if (max < 1)
                throw IllegalStateException("max should be positive, but was $max")

            if (max < step)
                throw IllegalStateException("max should be more than step")

            if (max < min)
                throw IllegalStateException("max should be more than min")
        }

        override fun initial(number: String): UiState {
            val digit = number.toInt()

            return if (digit + step > max || digit == max)
                UiState.Max(text = number)
            else if (digit - step < min || digit == min)
                UiState.Min(text = number)
            else
                UiState.Base(text = number)

        }

        override fun increment(number: String): UiState {
            val digit = number.toInt()
            val result = digit + step

            return if (max - result < step)
                UiState.Max(text = result.toString())
            else
                UiState.Base(text = result.toString())
        }

        override fun decrement(number: String): UiState {
            val digit = number.toInt()
            val result = digit - step

            return if (result - step < min)
                UiState.Min(text = result.toString())
            else
                UiState.Base(text = result.toString())
        }


    }

}