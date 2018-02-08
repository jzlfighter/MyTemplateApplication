package com.example.mytemplateapplication.service

import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Intent
import android.util.Log
import java.util.*

/**
 * Created by Administrator on 2018/2/8.
 */
class DakaService : JobService() {

    val TAG = DakaService::class.java.simpleName
    lateinit var workThread: WorkThread

    override fun onCreate() {
        super.onCreate()
        workThread = WorkThread()
    }

    override fun onStartJob(params: JobParameters?): Boolean {
        workThread.start()
        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        Log.d(TAG, "stop")
        workThread.interrupt()
        return true
    }

    inner class WorkThread : Thread() {
        override fun run() {
            super.run()
            Log.d(TAG, "start")
            while (!isInterrupted) {
                val calendar = Calendar.getInstance()
                if (calendar.get(Calendar.HOUR_OF_DAY) == 8 && calendar.get(Calendar.MINUTE) == 45) {
                    val intent: Intent
                    intent = packageManager.getLaunchIntentForPackage("com.alibaba.android.rimet")
                    startActivity(intent)
                    interrupt()
                }
            }
        }
    }

}