package com.kenny.a160420050_week4.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.kenny.a160420050_week4.R
import com.kenny.a160420050_week4.util.createNotificationChannel

class MainActivity() : AppCompatActivity() {

    companion object{
        private var instance:MainActivity ?= null

        fun showNotif(title:String, content:String, icon:Int){
            val chanelId = "${instance?.packageName}-${instance?.getString(R.string.app_name)}"

            val notificationBuilder =
                NotificationCompat.Builder(instance!!.applicationContext, chanelId).apply {
                    this.setSmallIcon(icon)
                    this.setContentTitle(title)
                    this.setContentText(content)
                    this.setStyle(NotificationCompat.BigTextStyle())
                    this.priority =NotificationCompat.PRIORITY_DEFAULT
                    this.setAutoCancel(true)

                }
            val notificationManager = NotificationManagerCompat.from(instance!!.applicationContext.applicationContext!!)

            notificationManager.notify(1001, notificationBuilder.build())
        }
    }

    init {
        instance = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createNotificationChannel(this,
            NotificationManagerCompat.IMPORTANCE_DEFAULT, false,
            getString(R.string.app_name), "App notification channel.")

    }
}