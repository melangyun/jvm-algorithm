package dp

class BOJ11727 {
    fun solution() {
        val target = readln().toInt()
        val dp = IntArray(1001)
        dp[1] = 1
        dp[2] = 3

        for (i in 3..target) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10_007
        }
        println(dp[target])
    }
}