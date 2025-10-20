package dev.kruchkovenko.workoutdetails.mapper

import dev.kruchkovenko.core.model.WorkoutUI
import dev.kruchkovenko.domain.model.Video
import dev.kruchkovenko.workoutdetails.model.WorkoutDetailsUI
import dev.kruchkovenko.workoutdetails.model.WorkoutVideoUI


interface WorkoutMapper {
    fun fromVideoToVideoUI(video: Video): WorkoutVideoUI
    fun fromWorkoutUIToWorkoutDetailsUI(
        workout: WorkoutUI,
        videoUI: WorkoutVideoUI
    ): WorkoutDetailsUI
}
