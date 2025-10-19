package dev.kruchkovenko.data.network

import dev.kruchkovenko.data.network.model.response.WorkoutResponse
import retrofit2.Response
import retrofit2.http.GET

private const val PATH_WORKOUTS = "get_workouts"

interface WorkoutApi {
    @GET(PATH_WORKOUTS)
    suspend fun getWorkouts(): Response<List<WorkoutResponse>>
}
