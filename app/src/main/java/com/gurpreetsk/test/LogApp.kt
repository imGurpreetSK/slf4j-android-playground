package com.gurpreetsk.test

import android.app.Application
import org.apache.log4j.*
import org.apache.log4j.varia.LevelRangeFilter
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File

class LogApplication : Application() {

    companion object {
        val logger: Logger = LoggerFactory.getLogger(LogApplication::class.java)
    }

    override fun onCreate() {
        configureLogger()

        logger.info("Before Application onCreate()")
        super.onCreate()
        logger.info("After Application onCreate()")
    }

    private fun configureLogger() {
        val logsDir = File(filesDir, "logs")
        if (logsDir.mkdir()) {
            File(logsDir, "test.txt").apply {
                createNewFile()
                setWritable(true)
                setReadable(true)
            }
        }

        val logPattern = "%p    %r [%t] %c %x - %m%n"
        BasicConfigurator.configure(
            AsyncAppender().also {
                it.bufferSize = 64
                it.addAppender(
                    RollingFileAppender(
                        PatternLayout(logPattern),
                        "${filesDir}${File.separator}logs${File.separator}test.txt"
                    ).apply {
                        maximumFileSize = 10 * 1024 * 1024 // 2 MB
                        addFilter(LevelRangeFilter().apply {
                            levelMax = Level.FATAL
                            levelMin = Level.INFO
                        })
                    }
                )
            }
        )
    }
}
