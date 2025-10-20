package dev.kruchkovenko.workoutlist.mapper

import dev.kruchkovenko.core.model.WorkoutTypeUI
import dev.kruchkovenko.domain.model.Workout
import dev.kruchkovenko.domain.model.WorkoutType
import dev.kruchkovenko.core.model.WorkoutUI

class WorkoutMapperImpl : WorkoutMapper {
    override fun fromWorkoutToWorkoutUI(workout: Workout): WorkoutUI = with(workout) {
        WorkoutUI(
            id = id,
            title = title,
            description = description,
            duration = duration,
            type = fromWorkoutTypeToWorkoutTypeUI(type)
        )
    }

    override fun fromWorkoutTypeToWorkoutTypeUI(type: WorkoutType): WorkoutTypeUI {
        return WorkoutTypeUI.entries.first { it.name == type.name }
    }
}
