package boj.string

import java.math.BigInteger

/*
선생님이 상근이에게 준 종이에는 숫자와 알파벳 소문자로 되어있는 글자가 N줄있다.
HL 상근이는 여기서 숫자를 모두 찾은 뒤, 이 숫자를 비내림차순으로 정리해야한다.
    숫자의 앞에 0이 있는 경우에는 정리하면서 생략할 수 있다.

글자를 살펴보다가 숫자가 나오는 경우에는, 가능한 가장 큰 숫자를 찾아야 한다.
즉, 모든 숫자의 앞과 뒤에 문자가 있거나, 줄의 시작 또는 끝이어야 한다.

예를 들어, 01a2b3456cde478에서 숫자를 찾으면 1, 2, 3456, 478이다.

선생님이 준 종이의 내용이 주어졌을 때, 상근이의 숙제를 대신하는 프로그램을 작성하시오.

첫째 줄에 종이의 줄의 개수 N이 주어진다. (1 ≤ N ≤ 100)
다음 N개의 줄에는 각 줄의 내용이 주어진다. 각 줄은 최대 100글자이고, 항상 알파벳 소문자와 숫자로만 이루어져 있다.

상근이의 숙제를 대신하는 프로그램을 작성하시오.

예제입력
2
lo3za4
01

예제출력
1
3
4
*/
class BOJ2870 {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val num = br.readLine().toInt()
        val answer = mutableListOf<BigInteger>()
        repeat(num) {
            val input = br.readLine()
            answer += input.split(Regex("[a-z]+"))
                .filter { it.isNotEmpty() }
                .mapNotNull { BigInteger(it) }
        }
        println(answer.sorted().joinToString("\n"))
    }
}