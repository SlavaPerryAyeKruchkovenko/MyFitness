package dev.kruchkovenko.fitness.di

import android.app.Application
import dev.kruchkovenko.core.utils.Constants
import dev.kruchkovenko.fitness.BuildConfig
import dev.kruchkovenko.fitness.di.AppModule.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

object AppDiContainer {
    fun startKoinDi(application: Application) {
        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.DEBUG else Level.NONE)
            androidContext(application)
            properties(
                mapOf(
                    Constants.BASE_URL to BuildConfig.API_URL,
                )
            )
            modules(
                *appModule.toTypedArray()
            )
        }
    }
}
