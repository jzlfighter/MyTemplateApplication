package jzl.com.crackcodeinterview.O

import kotlin.jvm.JvmStatic
import jzl.com.crackcodeinterview.O.O5
import java.lang.Exception
import java.util.ArrayList
import java.util.concurrent.Semaphore
import java.util.concurrent.locks.ReentrantLock

/**
 * jzl.com.crackcodeinterview.F
 * Created by kingj on 2020/6/19 0019.
 * 15.5 同一个 Foo 实例 会被 传入 3 个 不同 的 线程。 threadA 会 调用 first， threadB 会 调用 second， threadC 会 调用 third。 设计 一种 机制， 确保 first 会在 second 之前 调用， second 会在 third 之前 调用。
 */
class O5 {
    inner class FooBad {
        var pauseTime = 1000
        var lock1: ReentrantLock? = null
        var lock2: ReentrantLock? = null
        fun first() {
            try {
                lock1!!.unlock()
            } catch (e: Exception) {
            }
        }

        fun second() {
            try {
                lock1!!.lock()
                lock1!!.unlock()
                lock2!!.unlock()
            } catch (e: Exception) {
            }
        }

        fun third() {
            try {
                lock2!!.lock()
                lock2!!.unlock()
            } catch (e: Exception) {
            }
        }

        init {
            try {
                lock1 = ReentrantLock()
                lock2 = ReentrantLock()
                lock1!!.lock()
                lock2!!.lock()
            } catch (e: Exception) {
            }
        }
    }

    inner class Foo {
        var sem1: Semaphore? = null
        var sem2: Semaphore? = null
        fun first() {
            try {
                //...
                sem1!!.release()
            } catch (e: Exception) {
            }
        }

        fun second() {
            try {
                sem1!!.acquire()
                sem1!!.release()
                //...
                sem2!!.release()
            } catch (e: Exception) {
            }
        }

        fun third() {
            try {
                sem2!!.acquire()
                sem2!!.release()
                //...
            } catch (e: Exception) {
            }
        }

        init {
            try {
                sem1 = Semaphore(1)
                sem2 = Semaphore(1)
                sem1!!.acquire()
                sem2!!.acquire()
            } catch (e: Exception) {
            }
        }
    }

    private val longboard = "long"
    private val shortboard = "short"
    private val array = arrayOf(longboard, shortboard)
    fun getAllBoard(k: Int): List<String> {
        val result = ArrayList<String>()
        for (i in array.indices) {
            result.addAll(recursion(k, 1, array[i]))
        }
        return result
    }

    private fun recursion(k: Int, index: Int, type: String): List<String> {
        val result = ArrayList<String>()
        if (index == k) {
            result.add(type)
        } else {
            for (i in array.indices) {
                val temp = recursion(k, index + 1, array[i]) as ArrayList<*>
                for (j in temp.indices) {
                    val s = temp[j].toString() + type
                    result.add(s)
                }
            }
        }
        return result
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(O5().getAllBoard(3).toString())
        }
    }
}
