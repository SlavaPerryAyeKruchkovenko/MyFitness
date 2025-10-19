package dev.kruchkovenko.workoutlist.mapper

import dev.kruchkovenko.domain.model.Workout
import dev.kruchkovenko.workoutlist.model.WorkoutTypeUI
import dev.kruchkovenko.workoutlist.model.WorkoutUI

class WorkoutMapperImpl : WorkoutMapper {
    override fun fromWorkoutToWorkoutUI(workout: Workout): WorkoutUI = with(workout) {
        WorkoutUI(
            id = id,
            title = title,
            description = description,
            duration = duration,
            type = WorkoutTypeUI.fromWorkType(type)
        )
    }
}
