package jzl.com.crackcodeinterview.C

import java.util.EmptyStackException

/**
 * 3.1　三合一。描述如何只用一个数组来实现三个栈。
 *
 * @author jiangzailong 2022/9/2
 */
class C1 {
}

class MultiStack(private val stackSize: Int) {

    private val stackNum = 3

    private val array = IntArray(stackSize * stackNum)

    private val size = IntArray(stackNum)

    fun pop(index: Int) {
        if (isEmpty(index) || stackIndexInvalid(index)) {
            throw EmptyStackException()
        }
        array[size[index]] = 0
        size[index]--
    }

    fun push(index: Int, value: Int) {
        if (isFull(index) || stackIndexInvalid(index)) {
            return
        }
        val startIndex = index * stackSize
        array[startIndex + size[index]] = value
        size[index]++
    }

    fun peek(index: Int): Int? {
        if (stackIndexInvalid(index)) {
            return null
        }
        val startIndex = index * stackSize
        return array[startIndex + size[index] - 1]
    }

    fun isEmpty(index: Int): Boolean {
        if (stackIndexInvalid(index)) {
            return true
        }
        return size[index] == 0
    }

    fun isFull(index: Int): Boolean {
        if (stackIndexInvalid(index)) {
            return true
        }
        return size[index] == stackSize - 1
    }

    private fun stackIndexInvalid(index: Int): Boolean {
        return index !in 0 until stackNum
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val myStack = MultiStack(10)
            myStack.push(2, 2)
            println(myStack.peek(2))
            myStack.pop(2)
            println(myStack.peek(2))
        }
    }
}
