package dp

import java.io.*

class BOJ15988 {
    fun solution() {
        val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
        val testCase = br.readLine().toInt()

        val answer = StringBuilder()
        val dp = LongArray(1_000_001)
        dp[1] = 1
        dp[2] = 2
        dp[3] = 4
        var top = 4

        repeat(testCase) {
            val n = br.readLine().toInt()
            if (n >= top) {
                for (i in top..n) {
                    dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1_000_000_009
                }
                top = n + 1
            }
            answer.append("${dp[n]}\n")
        }
        println(answer)
    }
}