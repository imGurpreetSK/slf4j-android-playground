package com.gurpreetsk.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        LogApplication.logger.info("Before Activity onCreate()")
        super.onCreate(savedInstanceState)
        LogApplication.logger.info("After Activity onCreate()")
        setContentView(R.layout.activity_main)

        (0..Long.MAX_VALUE).forEach {
            LogApplication.logger.error("YOLO $it")
        }
    }
}
