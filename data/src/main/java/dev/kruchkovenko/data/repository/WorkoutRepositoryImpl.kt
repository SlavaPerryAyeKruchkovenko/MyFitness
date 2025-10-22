package dev.kruchkovenko.data.repository

import dev.kruchkovenko.data.mapper.WorkoutMapper
import dev.kruchkovenko.data.network.WorkoutApi
import dev.kruchkovenko.domain.model.DataState
import dev.kruchkovenko.domain.model.Video
import dev.kruchkovenko.domain.model.Workout
import dev.kruchkovenko.domain.repository.WorkoutRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WorkoutRepositoryImpl(
    private val api: WorkoutApi,
    private val mapper: WorkoutMapper,
) : WorkoutRepository {
    override suspend fun getWorkouts(): DataState<List<Workout>> {
        return runCatching {
            withContext(Dispatchers.IO) {
                val result = api.getWorkouts()
                result.body()?.map(mapper::fromWorkoutResponseToWorkout) ?: emptyList()
            }
        }.fold(
            onSuccess = { DataState.Success(it) },
            onFailure = {
                it.printStackTrace()
                DataState.Error(it)
            }
        )
    }

    override suspend fun getVideo(id: Int): DataState<Video?> {
        return runCatching {
            withContext(Dispatchers.IO) {
                val result = api.getVideo(id)
                val body = result.body()
                body?.let {
                    mapper.fromVideResponseToVideo(it)
                }
            }
        }.fold(
            onSuccess = { DataState.Success(it) },
            onFailure = {
                it.printStackTrace()
                DataState.Error(it)
            }
        )
    }
}
