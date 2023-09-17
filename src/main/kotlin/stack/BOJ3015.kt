package stack

import java.util.Stack

/*
오아시스의 재결합 공연에 N명이 한 줄로 서서 기다리고 있다.
이 역사적인 순간을 맞이하기 위해 줄에서서 기다리고 있던 백준이는 갑자기 자기가 볼 수 있는 사람의 수가 궁금해 졌다.
두 사람 A와 B가 서로 볼 수 있으려면, HL 두 사람 사이에 A 또는 B보다 키가 큰 사람이 없어야 한다.
줄에 서있는 사람의 키가 주어졌을 때, 서로 볼 수 있는 쌍의 수를 구하는 프로그램을 작성하시오.

첫째 줄에 줄에서 기다리고 있는 사람의 수 N이 주어진다. (1 ≤ N ≤ 500,000)
둘째 줄부터 N개의 줄에는 각 사람의 키가 나노미터 단위로 주어진다. 모든 사람의 키는 231 나노미터 보다 작다.
사람들이 서 있는 순서대로 입력이 주어진다.

서로 볼 수 있는 쌍의 수를 출력한다.

예제 입력
7
2
4
1
2
2
5
1

출력
10
*/
class BOJ3015 {
    fun solution(): Int {
        val br = System.`in`.bufferedReader()
        val num = br.readLine().toInt()
        val people = arrayOfNulls<Int>(num).map { br.readLine().toInt() }

        var answer = 0
        val stack = Stack<Int>()
        for (i in people.indices) {
            val person = people[i]
            // 예제 입출력에서 A가 2번, B가 5번 인덱스라고 할때, A와 B는 서로를 볼 수 있다.
            // 5번 인덱스는 누구보다 키가 크기때문에 모두를 볼 수 있다.
            // 2번 인덱스는 3번 인덱스보다 키가 작고, 4번 인덱스틑 3번과 키가 같기때문에 2번과 4번은 볼 수 없다.
            // 2번과 3번은 서로를 볼 수 있다.
            while (stack.isNotEmpty() && stack.peek() <= person ) {
                stack.pop()
                answer++
            }


            stack.push(person)
        }

        return answer;
    }
}