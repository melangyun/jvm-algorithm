package bfs

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.*

class BOJ14442Test {
    private val testCase = listOf(
        """6 4 1
0100
1110
1000
0000
0111
0000""" to 15,
        """6 4 2
0100
1110
1000
0000
0111
0000""" to 9,
        """4 4 3
0111
0111
1111
1111
1110""" to -1,
        """1 1 1
0""" to 1,
        """3 3 2
011
111
110""" to -1,
        """2 4 2
0111
0110""" to 5,
        """3 3 10
011
011
000""" to 5,
        """3 3 3
011
111
110""" to 5,
        """5 5 4
01101
11100
00111
11110
00110""" to 9,
        """4 4 2
0111
1101
0001
0110""" to 7,
        """4 2 1
01
00
11
10""" to 5,
        """4 4 2
0100
0001
0011
0110""" to 7
    )

    @Test
    fun solution() {
        val solutionClass = BOJ14442()
        for ((input, output) in testCase) {
            val arrayInputStream = ByteArrayInputStream(input.toByteArray())
            val br = BufferedReader(InputStreamReader(arrayInputStream))
            assertEquals(output, solutionClass.solution(br))
        }
    }
}