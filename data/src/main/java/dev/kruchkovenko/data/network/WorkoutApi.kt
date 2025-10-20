package dev.kruchkovenko.data.network

import dev.kruchkovenko.data.network.model.response.VideoResponse
import dev.kruchkovenko.data.network.model.response.WorkoutResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

private const val PATH_WORKOUTS = "get_workouts"
private const val PATH_VIDEO = "get_video"

interface WorkoutApi {
    @GET(PATH_WORKOUTS)
    suspend fun getWorkouts(): Response<List<WorkoutResponse>>

    @GET(PATH_VIDEO)
    suspend fun getVideo(@Query("id") id: Int): Response<VideoResponse>
}
