package dev.kruchkovenko.workoutlist.navigation

import dev.kruchkovenko.core.model.WorkoutUI

interface WorkoutListNavigator {
    fun openWorkoutDetails(workout: WorkoutUI)
}
