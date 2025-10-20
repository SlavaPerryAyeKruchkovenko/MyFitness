package dev.kruchkovenko.workoutdetails.model

import dev.kruchkovenko.core.model.WorkoutUI
import dev.kruchkovenko.core.presenter.Event

sealed class WorkoutDetailsEvent : Event() {
    data class Init(val workout: WorkoutUI) : WorkoutDetailsEvent()
}
