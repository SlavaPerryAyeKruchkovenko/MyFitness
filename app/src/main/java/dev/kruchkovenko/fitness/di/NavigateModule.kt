package dev.kruchkovenko.fitness.di

import androidx.navigation.NavController
import dev.kruchkovenko.fitness.navigator.AppNavigator
import dev.kruchkovenko.workoutlist.navigation.WorkoutListNavigator
import org.koin.dsl.module

object NavigateModule {
    val navigateModule = module {
        factory<WorkoutListNavigator> { (navController: NavController) ->
            AppNavigator(navController)
        }
    }
}
