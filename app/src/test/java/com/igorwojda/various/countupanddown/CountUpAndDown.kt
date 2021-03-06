package com.igorwojda.various.countupanddown

import org.amshove.kluent.shouldEqual
import org.junit.Test

private fun countUpAndDown(n: Int): List<Int> {
    return emptyList()
}

class CountUpAndDownTest {
    @Test
    fun `count up and down 0`() {
        countUpAndDown(0) shouldEqual listOf(0)
    }

    @Test
    fun `count up and down 1`() {
        countUpAndDown(1) shouldEqual listOf(0, 1, 0)
    }

    @Test
    fun `count up and down 2`() {
        countUpAndDown(2) shouldEqual listOf(0, 1, 2, 1, 0)
    }

    @Test
    fun `count up and down 4`() {
        countUpAndDown(4) shouldEqual listOf(0, 1, 2, 3, 4, 3, 2, 1, 0)
    }
}
