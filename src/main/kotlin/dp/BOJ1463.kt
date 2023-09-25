package dp

/*
다이나믹 프로그래밍: (Dynamic Programming; dp)
: 여러개의 하위 문제를 풀고, 그것을 결합하여 최종 목적에 도달하는 문제 해결 방식

ex) 피보나치의 경우 재귀로 풀 때 보다, 이전 값을 저장해두고 사용하는 것이 훨씬 더 효율적이다.

1. 최적 부분 구조 (Optimal Substructure)
: 큰 문제를 작은 문제로 나눌 수 있으며, 작은 문제의 답을 모아서 큰 문제를 해결할 수 있다.

2. 중복되는 부분 문제 (Overlapping Subproblem)
: 동일한 작은 문제를 반복적으로 해결해야 한다.

3. 메모이제이션 (Memoization)
: 동일한 작은 문제를 반복적으로 해결해야 한다.

4. 탑다운 (Top-Down)
: 큰 문제를 해결하기 위해 작은 문제를 호출한다.

https://www.acmicpc.net/problem/1463

정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

X가 3으로 나누어 떨어지면, 3으로 나눈다.
X가 2로 나누어 떨어지면, 2로 나눈다.
1을 뺀다.
정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.

예시입력
2

예시출력
1

*/
class BOJ1463 {
    fun solution (input: Int = readln().toInt()){
        val d = IntArray(input + 1)
        for (i in 2..input) {
            d[i] = d[i - 1] + 1
            if (i % 2 == 0) d[i] = minOf(d[i], d[i / 2] + 1)
            if (i % 3 == 0) d[i] = minOf(d[i], d[i / 3] + 1)
        }
        println(d[input])
    }
}