package dev.kruchkovenko.workoutdetails.model

import dev.kruchkovenko.core.presenter.Event

sealed class WorkoutDetailsEvent : Event() {
    data object Init : WorkoutDetailsEvent()
}
