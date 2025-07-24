package boj.linked_list

/*
연세대학교가 위치한 신촌역이 속한 2호선은 그림과 같이 $N$개의 역이 원형으로 연결되어 있다.
각 역은 고유 번호가 할당돼 있으며 역들의 고유 번호는 서로 다르다.
그리고 특정 역의 다음 역은 시계 방향으로 인접한 역을 의미하고, 이전 역은 반시계 방향으로 인접한 역을 의미한다.

2호선은 지하철 노선들 중 유일한 흑자 노선이다. 때문에 2호선 공사 자금이 넉넉하기에
$M$번의 공사를 거치려고 한다. 각 공사는 다음 4가지 중 하나를 시행한다.

BN i j
고유 번호 i를 가진 역의 HL 다음 역의 고유 번호를 출력하고,
그 사이에 고유 번호 j인 역을 설립한다.

BP i j
고유 번호 i를 가진 역의 HL 이전 역의 고유 번호를 출력하고,
그 사이에 고유 번호 j인 역을 설립한다.

CN i j
고유 번호 i를 가진 역의 HL 다음 역을 폐쇄하고
그 역의 고유 번호를 출력한다.

CP i j
고유 번호 i를 가진 역의 HL 이전 역을 폐쇄하고
그 역의 고유 번호를 출력한다.

이 때, HL 이미 설립한 역은 다시 설립하지 않으며 폐쇄한 역은 다시 설립될 수 있다.
        그리고 폐쇄 작업은 현재 설립된 역이 2개 이상일 때만 들어온다.


2호선을 공사하는 프로그램을 만들어보자.
*/
class RailwayConstruction(stationInfo: List<Int>) {
    private val stations = Array(1000001) { IntArray(2) }

    init {
        stationInfo.forEachIndexed { index, station ->
            val next = (index + 1) % stationInfo.size
            val prev = (index - 1 + stationInfo.size) % stationInfo.size
            stations[station][0] = stationInfo[prev]
            stations[station][1] = stationInfo[next]
        }
    }

    fun getStationInfo(target: Int): Pair<Int, Int> {
        return Pair(stations[target][0], stations[target][1])
    }

    fun buildNewStation(prev: Int, next: Int, new: Int) {
        stations[new][0] = prev
        stations[new][1] = next

        stations[next][0] = new
        stations[prev][1] = new
    }

    fun destroy(target: Int) {
        val prev = stations[target][0]
        val next = stations[target][1]
        stations[prev][1] = next
        stations[next][0] = prev
    }
}

class BOJ23309 {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val (_, constructionNum) = br.readLine().split(" ").map(String::toInt)
        val stations = HashMap<String, Pair<String, String>>();

        val stationInfo = br.readLine().split(" ")
        stationInfo.forEachIndexed { index, s ->
            val next = (index + 1) % stationInfo.size
            val prev = (index - 1 + stationInfo.size) % stationInfo.size
            stations[s] = Pair(stationInfo[prev], stationInfo[next])
        }

        val answer = StringBuilder()
        repeat(constructionNum) {
            val command = br.readLine().split(" ")
            val target = command[1]
            when (command[0]) {
                "BN" -> {// 다음 역의 고유 번호를 출력하고, 그 사이에 고유 번호 j인 역을 설립
                    val new = command[2]
                    val (prev, next) = stations[target]!!
                    val nextDestination = stations[next]!!

                    answer.append("$next\n")
                    stations[new] = Pair(target, next)
                    stations[next] = Pair(new, nextDestination.second)
                    stations[target] = Pair(prev, new)
                }

                "BP" -> { // 이전 역의 고유 번호를 출력하고, 그 사이에 고유 번호 j인 역을 설립한다.
                    val new = command[2]
                    val (prev, next) = stations[target]!!
                    val prevDestination = stations[prev]!!

                    answer.append("$prev\n")
                    stations[new] = Pair(prev, target)
                    stations[prev] = Pair(prevDestination.first, new)
                    stations[target] = Pair(new, next)
                }

                "CN" -> { // 다음 역 폐쇄
                    val (prev, next) = stations[target]!!
                    val nextDestination = stations[next]!!

                    answer.append("$next\n")
                    stations[target] = Pair(prev, nextDestination.second)
                }

                "CP" -> { // 이전 역 폐쇄
                    val (prev, next) = stations[target]!!
                    val prevDestination = stations[prev]!!

                    answer.append("$prev\n")
                    stations[target] = Pair(prevDestination.first, next)
                }

            }
        }
        println(answer)
    }

    // 위 코드를 hashmap대신 int array로 구현한 코드
    fun solution2() {
        val br = System.`in`.bufferedReader()
        val (_, constructionNum) = br.readLine().split(" ").map(String::toInt)

        val stationInfo = br.readLine().split(" ").map(String::toInt)
        val railwayConstruction = RailwayConstruction(stationInfo)

        val answer = StringBuilder()
        repeat(constructionNum) {
            val command = br.readLine().split(" ")
            val target = command[1].toInt()
            when (command[0]) {
                "BN" -> {// 다음 역의 고유 번호를 출력하고, 그 사이에 고유 번호 j인 역을 설립
                    val new = command[2].toInt()
                    val next = railwayConstruction.getStationInfo(target).second
                    railwayConstruction.buildNewStation(target, next, new)
                    answer.append("$next\n")

                }

                "BP" -> { // 이전 역의 고유 번호를 출력하고, 그 사이에 고유 번호 j인 역을 설립한다.
                    val new = command[2].toInt()
                    val prev = railwayConstruction.getStationInfo(target).first
                    railwayConstruction.buildNewStation(prev, target, new)
                    answer.append("$prev\n")
                }

                "CN" -> { // 다음 역 폐쇄
                    val next = railwayConstruction.getStationInfo(target).second
                    railwayConstruction.destroy(next)
                    answer.append("$next\n")
                }

                "CP" -> { // 이전 역 폐쇄
                    val prev = railwayConstruction.getStationInfo(target).first
                    railwayConstruction.destroy(prev)
                    answer.append("$prev\n")
                }

            }
        }
        println(answer)
    }
}
