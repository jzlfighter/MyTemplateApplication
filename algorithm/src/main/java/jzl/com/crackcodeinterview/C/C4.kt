package jzl.com.crackcodeinterview.C

import java.util.Stack

/**
 * 3.4　化栈为队。实现一个MyQueue类，该类用两个栈来实现一个队列。
 *
 * @author jiangzailong 2022/9/2
 */
class C4 {
}

class TwoStackToOneQueue {

    private val newestStack = Stack<Int>()
    private val oldestStack = Stack<Int>()

    public fun size(): Int {
        return newestStack.size + oldestStack.size
    }

    public fun add(value: Int) {
        newestStack.push(value)
    }

    public fun remove() {
        shiftStack()
        oldestStack.pop()
    }

    public fun peek(): Int {
        shiftStack()
        return oldestStack.peek()
    }

    private fun shiftStack() {
        if (oldestStack.isEmpty()) {
            while (!newestStack.isEmpty()) {
                oldestStack.push(newestStack.pop())
            }
        }
    }
}
