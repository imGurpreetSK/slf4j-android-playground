package com.gurpreetsk.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        LogApplication.logger.info("Before onCreate()")
        super.onCreate(savedInstanceState)
        LogApplication.logger.info("After onCreate()")
        setContentView(R.layout.activity_main)
    }
}
