package leetcode.stack

import java.util.Stack

class NextGreaterElement {
    // TODO: 음.. 다시 봐보기
    fun nextGreaterElement1(nums1: IntArray, nums2: IntArray): IntArray {
        val answer = mutableListOf<Int>()

        for(target in nums1){
            var found = false
            for(i in nums2.indices){
                if(nums2[i] == target){
                    for(j in i + 1..<nums2.size){
                        if(nums2[j] > target){
                            answer.add(nums2[j])
                            found = true
                            break
                        }
                    }
                    if(!found) {
                        answer.add(-1)
                    }
                    break
                }
            }
        }

        return answer.toIntArray()
    }

    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val stack = Stack<Int>()
        val map = mutableMapOf<Int, Int>()

        for (num in nums2.reversed()) {
            while (stack.isNotEmpty() && stack.peek() <= num) {
                stack.pop()
            }
            map[num] = if (stack.isEmpty()) -1 else stack.peek()
            stack.push(num)
        }

        return nums1.map { map[it] ?: -1 }.toIntArray()
    }
}