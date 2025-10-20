package dev.kruchkovenko.workoutdetails.mapper

import dev.kruchkovenko.core.model.WorkoutUI
import dev.kruchkovenko.domain.model.Video
import dev.kruchkovenko.workoutdetails.model.WorkoutDetailsUI
import dev.kruchkovenko.workoutdetails.model.WorkoutVideoUI

class WorkoutMapperImpl : WorkoutMapper {

    override fun fromVideoToVideoUI(video: Video): WorkoutVideoUI = with(video) {
        WorkoutVideoUI(
            id = id,
            duration = duration,
            link = link,
        )
    }

    override fun fromWorkoutUIToWorkoutDetailsUI(
        workout: WorkoutUI,
        videoUI: WorkoutVideoUI?
    ): WorkoutDetailsUI = with(workout) {
        WorkoutDetailsUI(
            id = id,
            title = title,
            description = description,
            duration = duration,
            type = type,
            video = videoUI
        )
    }
}
