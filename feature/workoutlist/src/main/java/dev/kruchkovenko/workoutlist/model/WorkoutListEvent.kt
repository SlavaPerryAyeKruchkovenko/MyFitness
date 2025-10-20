package dev.kruchkovenko.workoutlist.model

import dev.kruchkovenko.core.model.WorkoutTypeUI
import dev.kruchkovenko.core.presenter.Event

sealed class WorkoutListEvent : Event() {
    data object Init : WorkoutListEvent()
    data class Search(val text: String) : WorkoutListEvent()
    data class Filter(val type: WorkoutTypeUI): WorkoutListEvent()
}
