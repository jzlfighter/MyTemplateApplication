package jzl.com.crackcodeinterview.A

/**
 * 1.1　判定字符是否唯一。实现一个算法，确定一个字符串的所有字符是否全都不同。假使不允许使用额外的数据结构，又该如何处理？（提示：#44，#117，#132）
 *
 * @author jiangzailong 2022/9/20
 */
class A1 {

    fun unique(s: String): Boolean {
        val array = BooleanArray(128)
        var result = true
        s.chars().forEach {
            if (array[it]) {
                result = false
            }
            array[it] = true
        }
        return result
    }
}
