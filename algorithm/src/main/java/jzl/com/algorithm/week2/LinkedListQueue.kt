package jzl.com.algorithm.week2

/**
 * 链表实现的队列
 *
 * @author jiangzailong 2023/10/15
 */
class LinkedListQueue {

    var first: ListNode<String>? = null

    var last: ListNode<String>? = null

    fun enqueue(value: String) {
        val newLast = ListNode(null, value)
        if (first == null) {
            first = newLast
            last = newLast
        } else {
            last?.next = newLast
            last = newLast
        }
    }

    fun dequeue(): String? {
        if (first == null) {
            return null
        }
        val result = first?.value
        if (first == last) {
            first = null
            last = null
        } else {
            first = first?.next
        }
        return result
    }

    fun size(): Int {
        var result = 0
        var tempFirst = first
        while (tempFirst != null) {
            result++
            tempFirst = tempFirst.next
        }
        return result
    }

    fun isEmpty(): Boolean = size() != 0
}
