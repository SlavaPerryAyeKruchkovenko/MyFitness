package dev.kruchkovenko.fitness

import android.app.Application
import dev.kruchkovenko.fitness.di.AppDiContainer

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        AppDiContainer.startKoinDi(this)
    }
}
