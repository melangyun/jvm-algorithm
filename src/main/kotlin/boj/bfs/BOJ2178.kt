package boj.bfs

import java.io.*
import java.util.LinkedList

// https://www.acmicpc.net/problem/2178

/*
미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오
*/
class BOJ2178 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (N, M) = br.readLine().split(" ").map(String::toInt)
        val map = Array<IntArray>(N) { br.readLine().map(Character::getNumericValue).toIntArray() }
        val visited = Array<IntArray>(N) { IntArray(M) }

        val dxy = arrayOf(intArrayOf(1, 0, -1, 0), intArrayOf(0, 1, 0, -1))
        val queue = LinkedList<Pair<Int, Int>>()

        queue.add(Pair(0, 0))
        visited[0][0] = 1

        while (queue.isNotEmpty()) {
            val (x, y) = queue.poll()

            for (i in 0 until 4) {
                val nx = x + dxy[0][i]
                val ny = y + dxy[1][i]

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue
                if (map[nx][ny] == 0 || visited[nx][ny] != 0) continue

                queue.add(Pair(nx, ny))
                visited[nx][ny] = visited[x][y] + 1
            }
        }

        println(visited[N - 1][M - 1])

    }
}