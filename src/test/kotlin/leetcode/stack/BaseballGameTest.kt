package leetcode.stack

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BaseballGameTest {
    @Test
    fun baseballGameTest1() {
        val baseballGame = BaseballGame()
        val operations2 = arrayOf("5", "-2", "4", "C", "D", "9", "+", "+")
        assertEquals(27, baseballGame.calPoints(operations2))
    }

    @Test
    fun baseballGameTest2() {
        val baseballGame = BaseballGame()
        val operations1 = arrayOf("5", "2", "C", "D", "+")

        assertEquals(30, baseballGame.calPoints(operations1))
    }

    @Test
    fun baseballGameTest3() {
        val baseballGame = BaseballGame()
        val operations3 = arrayOf("1", "C")

        assertEquals(0, baseballGame.calPoints(operations3))
    }
}