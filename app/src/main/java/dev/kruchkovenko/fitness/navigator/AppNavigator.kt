package dev.kruchkovenko.fitness.navigator

import androidx.navigation.NavController
import dev.kruchkovenko.core.model.WorkoutUI
import dev.kruchkovenko.workoutlist.navigation.WorkoutListNavigator
import dev.kruchkovenko.workoutlist.ui.WorkoutListFragmentDirections

class AppNavigator(
    private val navController: NavController
) : WorkoutListNavigator {
    override fun openWorkoutDetails(workout: WorkoutUI) {
        val action = WorkoutListFragmentDirections
            .actionWorkoutListFragmentToWorkoutDetailsFragment(workout)
        navController.navigate(action)
    }
}
