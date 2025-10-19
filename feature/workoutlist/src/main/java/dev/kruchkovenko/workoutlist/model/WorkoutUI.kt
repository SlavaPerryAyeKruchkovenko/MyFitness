package dev.kruchkovenko.workoutlist.model

data class WorkoutUI(
    val id: Int,
    val title: String,
    val description: String?,
    val duration: String,
    val type: WorkoutTypeUI,
)
