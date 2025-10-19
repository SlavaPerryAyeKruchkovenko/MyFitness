package dev.kruchkovenko.data.mapper

import dev.kruchkovenko.data.network.model.response.WorkoutResponse
import dev.kruchkovenko.domain.model.Workout

interface WorkoutMapper {
    fun fromWorkoutResponseToWorkout(response: WorkoutResponse): Workout
}
