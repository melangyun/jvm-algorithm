package dp

import java.io.*

class BOJ9461 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val n = br.readLine().toInt()
        val dp = LongArray(100)

        dp[0] = 1; dp[1] = 1; dp[2] = 1; dp[3] = 2; dp[4] = 2
        for (i in 5 until 100) {
            dp[i] = dp[i - 1] + dp[i - 5]
        }

        val answer = StringBuilder()
        repeat(n) {
            val idx = br.readLine().toInt()
            answer.append(dp[idx - 1])
                .append("\n")
        }
        println(answer)
    }
}