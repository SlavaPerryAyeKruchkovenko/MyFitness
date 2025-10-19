package dev.kruchkovenko.domain.repository

import dev.kruchkovenko.domain.model.DataState
import dev.kruchkovenko.domain.model.Workout

interface WorkoutRepository {
    suspend fun getWorkouts(): DataState<List<Workout>>
}
