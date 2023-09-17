package string

/*
Java 예찬론자 김동규와 C++ 옹호가 김동혁은 서로 어떤 프로그래밍 언어가 최고인지 몇 시간동안 토론을 하곤 했다.
동규는 Java가 명확하고 에러가 적은 프로그램을 만든다고 주장했고,
동혁이는 Java는 프로그램이 느리고, 긴 소스 코드를 갖는 점과 제네릭 배열의 인스턴스화의 무능력을 비웃었다.

또, 김동규와 김동혁은 변수 이름을 짓는 방식도 서로 달랐다.

Java에서는 변수의 이름이 여러 단어로 이루어져있을 때, 다음과 같은 방법으로 변수명을 짓는다.

HL  첫 단어는 소문자로 쓰고, 다음 단어부터는 첫 문자만 대문자로 쓴다.
    또, 모든 단어는 붙여쓴다.
따라서 Java의 변수명은 javaIdentifier, longAndMnemonicIdentifier, name, bAEKJOON과 같은 형태이다.

반면에 C++에서는 변수명에 HL 소문자만 사용한다.
                       단어와 단어를 구분하기 위해서 밑줄('_')을 이용한다.
C++ 변수명은 c_identifier, long_and_mnemonic_identifier, name, b_a_e_k_j_o_o_n과 같은 형태이다.

이 둘의 싸움을 부질없다고 느낀 재원이는 C++형식의 변수명을 Java형식의 변수명으로,
또는 그 반대로 바꿔주는 프로그램을 만들려고 한다.
각 언어의 변수명 형식의 위의 설명을 따라야 한다.

재원이의 프로그램은 가장 먼저 변수명을 입력으로 받은 뒤, 이 변수명이 어떤 언어 형식인지를 알아내야 한다.
그 다음, C++형식이라면 Java형식으로, Java형식이라면 C++형식으로 바꾸면 된다.
만약 C++형식과 Java형식 둘 다 아니라면, 에러를 발생시킨다.
변수명을 변환할 때, 단어의 순서는 유지되어야 한다.

재원이는 프로그램을 만들려고 했으나, 너무 귀찮은 나머지 이를 문제를 읽는 사람의 몫으로 맡겨놨다.

재원이가 만들려고 한 프로그램을 대신 만들어보자.
*/
class BOJ3613 {
    private val ERROR_CODE = "Error!";

    private fun camelToSnake(input: String): String {
        val answer = StringBuilder()
        input.forEach {
            if (it.isUpperCase()) {
                answer.append('_')
            }
            answer.append(it.lowercase())
        }
        return answer.toString()
    }

    private fun snakeToCamel(input: String): String {
        val answer = StringBuilder()
        var isFirst = false
        input.forEach {
            if (it == '_') {
                if (isFirst) {
                    return ERROR_CODE
                }
                isFirst = true
            } else if (isFirst) {
                isFirst = false
                answer.append(it.uppercase())
            } else {
                isFirst = false
                answer.append(it)
            }
        }
        return answer.toString()
    }

    private fun distinctLanguage(input: String): String {
        val uppercaseExist = input.firstOrNull() { it.isUpperCase() }
        val unerscoreExist = input.firstOrNull { it == '_' }
        val hasSpace = input.firstOrNull { it == ' ' } != null

        if (
            ((uppercaseExist != null) and (unerscoreExist != null))
            or hasSpace
            or input.first().isDigit() or input.first().isUpperCase() or (input.first() == '_')
            or (input.last() == '_')
        ) {
            return ERROR_CODE
        }
        if (uppercaseExist != null) {
            return "java"
        }
        return "c"
    }

    fun solution() {
        val br = System.`in`.bufferedReader()
        val input = br.readLine()
        val answer = when (distinctLanguage(input)) {
            "java" -> camelToSnake(input)
            "c" -> snakeToCamel(input)
            else -> ERROR_CODE
        }
        println(answer)
    }
}