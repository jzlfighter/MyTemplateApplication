package jzl.com.crackcodeinterview.A

/**
 * 1.2　判定是否互为字符重排。给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * @author jiangzailong 2022/9/21
 */
class A2 {

    fun permutation(s1: String, s2: String): Boolean {
        val map1 = hashMapOf<Int, Int>()
        s1.chars().forEach {
            val count = map1[it] ?: 0
            map1[it] = count + 1
        }
        val map2 = hashMapOf<Int, Int>()
        s2.chars().forEach {
            val count = map2[it] ?: 0
            map2[it] = count + 1
        }
        if (map1.keys.size != map2.keys.size) {
            return false
        }
        var result = true
        map1.keys.forEach {
            if (map1[it] != map2[it]) {
                result = false
                return@forEach
            }
        }
        return result
    }
}
