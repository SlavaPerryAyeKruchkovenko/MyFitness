package dev.kruchkovenko.workoutdetails.mapper

import dev.kruchkovenko.core.model.WorkoutTypeUI
import dev.kruchkovenko.domain.model.WorkoutType


interface WorkoutMapper {
    fun fromWorkoutTypeToWorkoutTypeUI(type: WorkoutType): WorkoutTypeUI
}
