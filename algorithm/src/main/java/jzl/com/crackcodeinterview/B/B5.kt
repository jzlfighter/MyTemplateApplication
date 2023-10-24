package jzl.com.crackcodeinterview.B

/**
 * 2.5　链表求和。给定两个用链表表示的整数，每个节点包含一个数位。这些数位是反向存放的，也就是个位排在链表首部。编写函数对这两个整数求和，并用链表形式返回结果。
 *
 * @author jiangzailong 2022/9/7
 */
class B5 {

    fun getSum(headNode1: ListNode, headNode2: ListNode): ListNode? {
        var carry = 0
        var result: ListNode? = null
        var resultPointer: ListNode? = null
        var pointer1: ListNode? = headNode1
        var pointer2: ListNode? = headNode2
        while (pointer1 != null || pointer2 != null || carry > 0) {
            val node = when {
                pointer1 != null && pointer2 != null -> {
                    val value = (pointer1.value + pointer2.value + carry) % 10
                    carry = value / 10
                    ListNode(null, value)
                }
                pointer1 != null -> {
                    val value = (pointer1.value + carry) % 10
                    carry = value / 10
                    ListNode(null, value)
                }
                pointer2 != null -> {
                    val value = (pointer2.value + carry) % 10
                    carry = value / 10
                    ListNode(null, value)
                }
                else -> {
                    carry = 0
                    ListNode(null, 1)
                }
            }
            pointer1 = pointer1?.next
            pointer2 = pointer2?.next
            if (result == null) {
                result = node
                resultPointer = node
            } else {
                resultPointer?.next = node
            }
        }
        return result
    }
}
