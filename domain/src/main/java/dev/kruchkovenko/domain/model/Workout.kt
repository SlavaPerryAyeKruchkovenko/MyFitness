package dev.kruchkovenko.domain.model

data class Workout(
    val id: Int,
    val title: String,
    val description: String?,
    val duration: String,
    val type: WorkoutType,
)
