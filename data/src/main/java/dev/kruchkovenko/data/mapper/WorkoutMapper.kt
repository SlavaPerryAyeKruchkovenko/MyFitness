package dev.kruchkovenko.data.mapper

import dev.kruchkovenko.data.network.model.response.VideoResponse
import dev.kruchkovenko.data.network.model.response.WorkoutResponse
import dev.kruchkovenko.domain.model.Video
import dev.kruchkovenko.domain.model.Workout

interface WorkoutMapper {
    fun fromWorkoutResponseToWorkout(response: WorkoutResponse): Workout
    fun fromVideResponseToVideo(response: VideoResponse): Video
}
