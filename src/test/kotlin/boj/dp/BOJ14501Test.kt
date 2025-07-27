package boj.dp

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import java.io.BufferedReader
import java.io.ByteArrayInputStream
import java.io.InputStreamReader

class BOJ14501Test {
    private val testCase = listOf(
        "7\n" +
                "3 10\n" +
                "5 20\n" +
                "1 10\n" +
                "1 20\n" +
                "2 15\n" +
                "4 40\n" +
                "2 200" to 45,
        "10\n" +
                "1 1\n" +
                "1 2\n" +
                "1 3\n" +
                "1 4\n" +
                "1 5\n" +
                "1 6\n" +
                "1 7\n" +
                "1 8\n" +
                "1 9\n" +
                "1 10" to 55,
        "10\n" +
                "5 10\n" +
                "5 9\n" +
                "5 8\n" +
                "5 7\n" +
                "5 6\n" +
                "5 10\n" +
                "5 9\n" +
                "5 8\n" +
                "5 7\n" +
                "5 6" to 20,
        "10\n" +
                "5 50\n" +
                "4 40\n" +
                "3 30\n" +
                "2 20\n" +
                "1 10\n" +
                "1 10\n" +
                "2 20\n" +
                "3 30\n" +
                "4 40\n" +
                "5 50" to 90,
        "3\n" +
                "3 100\n" +
                "1 99\n" +
                "1 2" to 101,
        "4\n" +
                "3 1\n" +
                "1 100\n" +
                "2 100\n" +
                "1 1000" to 1100,
        "3\n" +
                "2 100\n" +
                "2 6\n" +
                "1 5" to 105,
        "3\n" +
                "2 10\n" +
                "5 20\n" +
                "1 10" to 20,
        "4\n" +
                "1 1\n" +
                "3 1\n" +
                "1 1\n" +
                "1 1" to 3,
        "5\n" +
                "4 10\n" +
                "2 9\n" +
                "2 3\n" +
                "2 2\n" +
                "3 100"
                to 11,
        "2\n" +
                "3 100\n" +
                "1 10" to 10,
        "7\n" +
                "3 10\n" +
                "5 20\n" +
                "1 10\n" +
                "2 20\n" +
                "4 15\n" +
                "2 10\n" +
                "2 200" to 40,
        "6\n" +
                "3 20\n" +
                "2 70\n" +
                "3 100\n" +
                "1 40\n" +
                "1 40\n" +
                "1 11\n" to 161,
        "5\n" +
                "1 6\n" +
                "3 9\n" +
                "3 6\n" +
                "4 9\n" +
                "1 1" to 16,
        "6\n" +
                "1 10\n" +
                "1 10\n" +
                "2 10\n" +
                "1 15\n" +
                "1 10\n" +
                "1 10" to 55,
        "5\n" +
                "1 100\n" +
                "4 200\n" +
                "1 99\n" +
                "2 150\n" +
                "1 160\n" to 359
    )

    @Test
    fun solution() {
        val solutionClass = BOJ14501()
        for ((input, output) in testCase) {
            val arrayInputStream = ByteArrayInputStream(input.encodeToByteArray())
            val br = BufferedReader(InputStreamReader(arrayInputStream))
            solutionClass.solution(br) shouldBe output
        }
    }
}