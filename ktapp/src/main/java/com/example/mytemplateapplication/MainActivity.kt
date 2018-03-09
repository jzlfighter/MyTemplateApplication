package com.example.mytemplateapplication

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import com.example.mytemplateapplication.service.DakaService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val JOBID = 100
    lateinit var scheduler: JobScheduler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        scheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
        btStart.setOnClickListener { scheduleJob() }
        btStop.setOnClickListener {
            scheduler.cancel(JOBID)
        }
        btLogin.setOnClickListener{startActivity(Intent(this,LoginActivity::class.java))}
    }

    private fun scheduleJob() {
        val builder = JobInfo.Builder(JOBID, ComponentName(this, DakaService::class.java))
//        builder.setMinimumLatency(0)
//        builder.setOverrideDeadline(0)
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
//        builder.setRequiresDeviceIdle(false)
//        builder.setRequiresCharging(false)
        scheduler.schedule(builder.build())
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.d("dd", event?.x.toString() + "," + event?.y)
        return super.onTouchEvent(event)
    }

}
