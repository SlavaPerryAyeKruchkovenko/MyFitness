package dev.kruchkovenko.data.mapper

import dev.kruchkovenko.data.network.model.response.VideoResponse
import dev.kruchkovenko.data.network.model.response.WorkoutResponse
import dev.kruchkovenko.domain.model.Video
import dev.kruchkovenko.domain.model.Workout
import dev.kruchkovenko.domain.model.WorkoutType

class WorkoutMapperImpl : WorkoutMapper {
    override fun fromWorkoutResponseToWorkout(response: WorkoutResponse): Workout = with(response) {
        Workout(
            id = id,
            title = title,
            description = description,
            duration = duration,
            type = WorkoutType.fromCode(type),
        )
    }

    override fun fromVideResponseToVideo(response: VideoResponse): Video = with(response) {
        Video(
            id = id,
            duration = duration,
            link = link,
        )
    }
}
