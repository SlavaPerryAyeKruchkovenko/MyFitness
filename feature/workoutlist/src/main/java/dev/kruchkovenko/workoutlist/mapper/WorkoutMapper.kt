package dev.kruchkovenko.workoutlist.mapper

import dev.kruchkovenko.core.model.WorkoutTypeUI
import dev.kruchkovenko.domain.model.Workout
import dev.kruchkovenko.domain.model.WorkoutType
import dev.kruchkovenko.core.model.WorkoutUI


interface WorkoutMapper {
    fun fromWorkoutToWorkoutUI(workout: Workout): WorkoutUI
    fun fromWorkoutTypeToWorkoutTypeUI(type: WorkoutType): WorkoutTypeUI
}
