package dev.kruchkovenko.workoutlist.model

import dev.kruchkovenko.core.model.WorkoutTypeUI
import dev.kruchkovenko.core.model.WorkoutUI

sealed class WorkoutListState {
    data object Empty : WorkoutListState()
    data object Loading : WorkoutListState()
    data class Error(val message: String) : WorkoutListState()
    data class Display(
        val workouts: List<WorkoutUI>,
        val displayWorkouts: List<WorkoutUI>,
        val searchText: String?,
        val workoutType: WorkoutTypeUI,
    ) : WorkoutListState()
}
