package dev.kruchkovenko.fitness.di

import dev.kruchkovenko.core.di.CoreModule.coreModule
import dev.kruchkovenko.data.di.DataModule.dataModule
import dev.kruchkovenko.domain.di.DomainModule.domainModule

object AppModule {
    val appModule = coreModule + dataModule + domainModule
}
