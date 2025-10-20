package dev.kruchkovenko.fitness.di

import dev.kruchkovenko.core.di.CoreModule.coreModule
import dev.kruchkovenko.data.di.DataModule.dataModule
import dev.kruchkovenko.domain.di.DomainModule.domainModule
import dev.kruchkovenko.fitness.di.NavigateModule.navigateModule
import dev.kruchkovenko.workoutlist.di.WorkoutListModule.workoutListModule

object AppModule {
    val appModule = coreModule + dataModule + navigateModule + domainModule + workoutListModule
}
