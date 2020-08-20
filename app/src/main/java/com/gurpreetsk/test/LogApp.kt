package com.gurpreetsk.test

import android.app.Application
import org.apache.log4j.BasicConfigurator
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class LogApplication : Application() {

    companion object {
        val logger: Logger = LoggerFactory.getLogger(LogApplication::class.java)
    }

    override fun onCreate() {
        BasicConfigurator.configure()
        logger.info("Before onCreate()")
        super.onCreate()
        logger.info("After onCreate()")
    }
}
