package bfs

import java.io.*
import java.util.LinkedList

// https://www.acmicpc.net/problem/1926
class BOJ1926 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (N, M) = br.readLine().split(" ").map(String::toInt)

        val dxy = arrayOf(intArrayOf(1, 0, -1, 0), intArrayOf(0, 1, 0, -1))
        val visited = Array<BooleanArray>(N) { BooleanArray(M) }
        val map = Array<IntArray>(N) { br.readLine().split(" ").map(String::toInt).toIntArray() }

        val queue = LinkedList<Pair<Int, Int>>()

        var count = 0
        var max = 0
        for (i in 0 until N) {
            for (j in 0 until M) {
                if (map[i][j] == 0 || visited[i][j]) continue

                queue.add(Pair(i, j))
                visited[i][j] = true
                var area = 0
                while (queue.isNotEmpty()) {
                    val (x, y) = queue.poll()
                    area++

                    for (k in 0 until 4) {
                        val nx = x + dxy[0][k]
                        val ny = y + dxy[1][k]

                        if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue
                        if (map[nx][ny] == 0 || visited[nx][ny]) continue

                        queue.add(Pair(nx, ny))
                        visited[nx][ny] = true
                    }
                }

                count++
                max = maxOf(max, area)
            }
        }

        println("$count\n$max")
    }
}