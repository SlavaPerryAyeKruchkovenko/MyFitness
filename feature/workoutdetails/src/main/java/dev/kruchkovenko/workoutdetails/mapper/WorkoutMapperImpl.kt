package dev.kruchkovenko.workoutdetails.mapper

import dev.kruchkovenko.core.model.WorkoutTypeUI
import dev.kruchkovenko.domain.model.WorkoutType

class WorkoutMapperImpl : WorkoutMapper {

    override fun fromWorkoutTypeToWorkoutTypeUI(type: WorkoutType): WorkoutTypeUI {
        return WorkoutTypeUI.entries.first { it.name == type.name }
    }
}
