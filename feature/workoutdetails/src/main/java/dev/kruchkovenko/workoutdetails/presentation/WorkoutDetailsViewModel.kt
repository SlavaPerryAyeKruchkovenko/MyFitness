package dev.kruchkovenko.workoutdetails.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.kruchkovenko.core.model.WorkoutUI
import dev.kruchkovenko.core.presenter.EventHandler
import dev.kruchkovenko.core.utils.ExceptionHandler
import dev.kruchkovenko.domain.model.DataState
import dev.kruchkovenko.domain.usecase.`interface`.GetVideoUseCase
import dev.kruchkovenko.workoutdetails.mapper.WorkoutMapper
import dev.kruchkovenko.workoutdetails.model.WorkoutDetailsEvent
import dev.kruchkovenko.workoutdetails.model.WorkoutDetailsState
import kotlinx.coroutines.launch

class WorkoutDetailsViewModel(
    baseState: WorkoutDetailsState,
    private val mapper: WorkoutMapper,
    private val getVideoUseCase: GetVideoUseCase,
) : ViewModel(), EventHandler<WorkoutDetailsEvent> {
    private val _state = MutableLiveData(baseState)
    val state get() = _state

    private val handler = ExceptionHandler.coroutineExceptionHandler()

    override fun obtainEvent(event: WorkoutDetailsEvent) {
        when (val currentState = _state.value) {
            is WorkoutDetailsState.Loading -> reduce(event, currentState)
            is WorkoutDetailsState.Display -> reduce(event, currentState)
            is WorkoutDetailsState.Error -> reduce(event, currentState)
        }
    }

    private fun reduce(event: WorkoutDetailsEvent, state: WorkoutDetailsState.Loading) {
        when (event) {
            is WorkoutDetailsEvent.Init -> loadWorkoutDetail(event.workout)
        }
    }

    private fun reduce(event: WorkoutDetailsEvent, state: WorkoutDetailsState.Display) {
        when (event) {
            is WorkoutDetailsEvent.Init -> {}
        }
    }

    private fun reduce(event: WorkoutDetailsEvent, state: WorkoutDetailsState.Error) {
        when (event) {
            is WorkoutDetailsEvent.Init -> {}
        }
    }

    private fun loadWorkoutDetail(workout: WorkoutUI) = viewModelScope.launch(handler) {
        val video = getVideoUseCase(workout.id)
        _state.value = when (video) {
            is DataState.Success -> {
                val videoUI = video.result?.let {
                    mapper.fromVideoToVideoUI(it)
                }
                val workoutDetailsUI = mapper.fromWorkoutUIToWorkoutDetailsUI(workout, videoUI)
                WorkoutDetailsState.Display(
                    workout = workoutDetailsUI
                )
            }

            is DataState.Error -> WorkoutDetailsState.Error(
                video.error.message ?: "Unhandled Error"
            )
        }
    }
}
