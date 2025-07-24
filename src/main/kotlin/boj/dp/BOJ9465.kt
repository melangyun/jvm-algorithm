package boj.dp

import java.io.*

class BOJ9465 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val answer = StringBuilder()

        val t = br.readLine().toInt()

        repeat(t) {
            val n = br.readLine().toInt()
            val sticker = Array<IntArray>(2) { IntArray(n) }
            val dp = Array(2) { IntArray(n) }
            for (i in 0 until 2) {
                sticker[i] = br.readLine()
                    .split(" ")
                    .map(String::toInt)
                    .toIntArray()
            }

            if (n <= 1) {
                if (n == 0) {
                    answer.append(0)
                } else {
                    answer.append(maxOf(sticker[0][0], sticker[1][0]))
                }
                answer.append("\n")
                return@repeat
            }

            dp[0][0] = sticker[0][0]
            dp[1][0] = sticker[1][0]
            dp[0][1] = dp[1][0] + sticker[0][1]
            dp[1][1] = dp[0][0] + sticker[1][1]

            for (i in 2 until n) {
                dp[0][i] = maxOf(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i]
                dp[1][i] = maxOf(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i]
            }
            answer.append(maxOf(dp[0][n - 1], dp[1][n - 1])).append("\n")
        }
        println(answer)
    }
}