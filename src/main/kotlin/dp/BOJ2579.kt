package dp

import kotlin.math.max

/*
계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다.
즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.

연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
마지막 도착 계단은 반드시 밟아야 한다.

따라서 첫 번째 계단을 밟고 이어 두 번째 계단이나, 세 번째 계단으로 오를 수 있다.
하지만, 첫 번째 계단을 밟고 이어 네 번째 계단으로 올라가거나, 첫 번째, 두 번째, 세 번째 계단을 연속해서 모두 밟을 수는 없다.

각 계단에 쓰여 있는 점수가 주어질 때 이 게임에서 얻을 수 있는 총 점수의 최댓값을 구하는 프로그램을 작성하시오.

예시 입력
6
10
20
15
25
10
20

예시 출력
75
*/
class BOJ2579 {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val num = br.readLine().toInt()
        val stairs = IntArray(num).map { br.readLine().toInt() }
        if (num == 1) {
            return println(stairs[0])
        }
        // 테이블 정의하기
        // D[i][j]: 현재까지 j개의 계단을 연속해서 밟고 i번째 계단까지 올라섰을 때 점수 합의 최대값,
        // 단, i번째 계단은 반드시 밟아야 함
        val dp = Array<IntArray>(num) { IntArray(2) }

        // 초기값
        dp[0][0] = stairs[0]
        dp[1][0] = stairs[1]
        dp[1][1] = stairs[0] + stairs[1]
        for (i in 2 until num) {
            dp[i][0] = max(dp[i - 2][0], dp[i - 2][1]) + stairs[i]
            dp[i][1] = dp[i - 1][0] + stairs[i]
        }

        return println(max(dp[num - 1][0], dp[num - 1][1]))
    }

    /*
    TODO 이후 이러한 방식으로 다시 풀어보기
    //2차원 배열 대신 1차원 배열로도 풀 수 있다.
    fun solution2() {
        val br = System.`in`.bufferedReader()
        val num = br.readLine().toInt()
        val stairs = IntArray(num).map { br.readLine().toInt() }

        if (num == 1) {
            return println(stairs[0])
        }
        // 1. 테이블 정의
        // D[i] = i번째 계단 까지 올라섰을 때 밟지 않을 계단의 합의 최소값,
        // 단, i 번째 계단은 반드시 밟지 않을 계단으로 선택해야함
        val dp = IntArray(num)
        dp[0] = stairs[0]
        dp[1] = stairs[1]
        dp[2] = stairs[2]
//        dp[3] = dp[0] + stairs[3] // 안밟은 칸 + 현재 칸

    }*/
}