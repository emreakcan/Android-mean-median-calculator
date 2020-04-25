package com.mediancalculator

import org.junit.Assert.assertEquals
import org.junit.Test
import com.mediancalculator.median

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MathExtTest {
    private val DELTA = 1e-15

    @Test
    fun average_calculation_test() {
        assertEquals(2.5, floatArrayOf(1F,2F,3F,4F).average().round(1), DELTA)

        assertEquals(39.2, floatArrayOf(100F,200F,4F,3F,1F,-2F,3F,5F).average().round(1), DELTA)

        assertEquals(48.3, floatArrayOf(400F, 200F, 4F, 3F, 1F, -2F, 3F, 5F, 3.2F, 4F, 5F , 1.2F , -0.1F).average().round(1), DELTA)
    }

    @Test
    fun median_calculation_test() {
        assertEquals(2.5, floatArrayOf(1F,2F,3F,4F).toList().median().round(1), DELTA)

        assertEquals(3.5, floatArrayOf(100F,200F,4F,3F,1F,-2F,3F,5F).toList().median().round(1), DELTA)

        assertEquals(3.2, floatArrayOf(400F, 200F, 4F, 3F, 1F, -2F, 3F, 5F, 3.2F, 4F, 5F , 1.2F , -0.1F).toList().median().round(1), DELTA)
    }
}
