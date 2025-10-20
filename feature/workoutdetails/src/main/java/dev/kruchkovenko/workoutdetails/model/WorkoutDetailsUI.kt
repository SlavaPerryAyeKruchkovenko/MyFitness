package dev.kruchkovenko.workoutdetails.model

import dev.kruchkovenko.core.model.WorkoutTypeUI

data class WorkoutDetailsUI(
    val id: Int,
    val title: String,
    val description: String?,
    val duration: String,
    val type: WorkoutTypeUI,
    val video: WorkoutVideoUI?,
)
