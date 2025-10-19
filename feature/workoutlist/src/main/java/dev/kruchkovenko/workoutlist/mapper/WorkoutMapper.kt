package dev.kruchkovenko.workoutlist.mapper

import dev.kruchkovenko.domain.model.Workout
import dev.kruchkovenko.workoutlist.model.WorkoutUI


interface WorkoutMapper {
    fun fromWorkoutToWorkoutUI(workout: Workout): WorkoutUI
}
