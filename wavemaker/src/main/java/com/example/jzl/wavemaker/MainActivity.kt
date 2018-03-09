package com.example.jzl.wavemaker

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent

class MainActivity : AppCompatActivity() {

    companion object {
        init {
            System.loadLibrary("native-lib")
        }
    }

    private external fun touchEvent(action: Int)
    private external fun startEngine()
    private external fun stopEngine()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startEngine()
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        touchEvent(event.action)
        return super.onTouchEvent(event)
    }

    override fun onDestroy() {
        stopEngine()
        super.onDestroy()
    }
}
