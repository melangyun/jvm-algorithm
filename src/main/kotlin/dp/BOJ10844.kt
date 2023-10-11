package dp

/*
45656이란 수를 보자.
이 수는 인접한 모든 자리의 차이가 1이다. 이런 수를 계단 수라고 한다.
N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구해보자. 0으로 시작하는 수는 계단수가 아니다.

첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 100보다 작거나 같은 자연수이다.


*/

class BOJ10844 {
    fun solution() {
        val n = readln().toInt()
        val dp = Array(n + 1) { LongArray(10) }
        val mod = 1_000_000_000

        // 첫번째 자리수는 경우의 수가 하나
        for (i in 1..9) {
            dp[1][i] = 1
        }

        // 두번째 자리의 수부터 n번째 자리의 수까지 탐색
        for (i in 2..n) {
            // 현재 자리값을 0부터 9까지 탐색
            for (j in 0..9) {
                when (j) {
                    // j가 9라면, 이전 자리값은 8만 가능
                    9 -> dp[i][j] = dp[i - 1][8] % mod
                    // 0일때는 1만 가능
                    0 -> dp[i][j] = dp[i - 1][1] % mod
                    else -> dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod
                }
            }
        }
        println(dp[n].sum() % mod)
    }
}