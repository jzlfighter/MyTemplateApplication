package jzl.com.crackcodeinterview.D

/**
 * 4.5　合法二叉搜索树。实现一个函数，检查一棵二叉树是否为二叉搜索树。
 *
 * @author jiangzailong 2022/10/11
 */
class D5 {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println(getCount())
        }
    }

}

val result = arrayListOf<String>()

val array = CharArray(5)

fun getCount(): Int {
    for (a in 0..4) {
        for (b in 0..4) {
            if (b == a) {
                continue
            }
            for (c in 0..4) {
                if (c == a || c == b) {
                    continue
                }
                for (d in 0..4) {
                    if (d == a || d == b || d == c) {
                        continue
                    }
                    for (e in 0..4) {
                        if (e == a || e == b || e == c || e == d) {
                            continue
                        }
                        array[a] = 'a'
                        array[b] = 'b'
                        array[c] = 'c'
                        array[d] = 'd'
                        array[e] = 'e'
                        result.add(array.joinToString(""))
                    }
                }
            }
        }
    }
    result.removeIf { it.indexOf('a') == 0 || it.indexOf('a') == 4 || it.indexOf('b') == 1 }
    return result.size
}
