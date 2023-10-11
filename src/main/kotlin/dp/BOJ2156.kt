package dp

import java.io.*
import kotlin.math.max

// 포도주 잔을 선택하면 그 잔에 들어있는 포도주는 모두 마셔야 하고,
// 마신 후에는 원래 위치에 다시 놓아야 한다.
// 연속으로 놓여 있는 3잔을 모두 마실 수는 없다.
class BOJ2156 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val n = br.readLine().toInt()
        val jucies = IntArray(n).map { br.readLine().toInt() }

        if (n == 1) {
            return println(jucies[0])
        } else if (n == 2) {
            return println(jucies.sum())
        }

        val dp = Array(2) { IntArray(n) }
        dp[0][0] = jucies[0]
        dp[0][1] = jucies[1]
        dp[1][1] = jucies[0] + jucies[1]
        dp[0][2] = dp[0][0] + jucies[2]
        dp[1][2] = dp[0][1] + jucies[2]

        for (i in 3 until n) {
            dp[0][i] = max(
                max(dp[1][i - 3], dp[0][i - 3]),
                max(dp[1][i - 2], dp[0][i - 2])
            ) + jucies[i]

            dp[1][i] = dp[0][i - 1] + jucies[i]
        }
        println(max(dp[0].max(), dp[1].max()))
    }
}