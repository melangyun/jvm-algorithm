package leetcode

class LongestSubstringWithoutRepeatingCharacters {
    fun lengthOfLongestSubstring(s: String): Int {
        var longestLength = 0
        val seen = mutableSetOf<Char>()
        var left = 0

        for (right in s.indices) {
            while (s[right] in seen) {
                seen.remove(s[left])
                left++
            }
            seen.add(s[right])
            longestLength = maxOf(longestLength, right - left + 1)
        }

        return longestLength
    }
}