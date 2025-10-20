package dev.kruchkovenko.workoutdetails.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.kruchkovenko.core.presenter.EventHandler
import dev.kruchkovenko.core.utils.ExceptionHandler
import dev.kruchkovenko.workoutdetails.mapper.WorkoutMapper
import dev.kruchkovenko.workoutdetails.model.WorkoutDetailsEvent
import dev.kruchkovenko.workoutdetails.model.WorkoutDetailsState

class WorkoutDetailsViewModel(
    baseState: WorkoutDetailsState,
    private val mapper: WorkoutMapper,
) : ViewModel(), EventHandler<WorkoutDetailsEvent> {
    private val _state = MutableLiveData(baseState)
    val state get() = _state

    private val handler = ExceptionHandler.coroutineExceptionHandler()

    override fun obtainEvent(event: WorkoutDetailsEvent) {

    }
}
