package dev.kruchkovenko.workoutdetails.model

sealed class WorkoutDetailsState {
    data object Loading : WorkoutDetailsState()
    data class Error(val message: String) : WorkoutDetailsState()
    data class Display(val workout: WorkoutDetailsUI) : WorkoutDetailsState()
}
