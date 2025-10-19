package dev.kruchkovenko.workoutlist.model

sealed class WorkoutState {
    data object Empty : WorkoutState()
    data object Loading : WorkoutState()
    data class Error(val message: String) : WorkoutState()
    data class Display(
        val workouts: List<WorkoutUI>,
        val displayWorkouts: List<WorkoutUI>,
        val searchText: String?,
        val workoutType: WorkoutTypeUI,
    ) : WorkoutState()
}
