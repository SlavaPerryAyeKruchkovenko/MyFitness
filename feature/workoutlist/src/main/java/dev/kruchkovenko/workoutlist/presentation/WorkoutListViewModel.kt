package dev.kruchkovenko.workoutlist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.kruchkovenko.core.presenter.EventHandler
import dev.kruchkovenko.core.utils.ExceptionHandler
import dev.kruchkovenko.domain.model.DataState
import dev.kruchkovenko.domain.usecase.`interface`.GetWorkoutsUseCase
import dev.kruchkovenko.workoutlist.mapper.WorkoutMapper
import dev.kruchkovenko.workoutlist.model.WorkoutListEvent
import dev.kruchkovenko.workoutlist.model.WorkoutListState
import dev.kruchkovenko.core.model.WorkoutTypeUI
import kotlinx.coroutines.launch

class WorkoutListViewModel(
    baseState: WorkoutListState,
    private val getWorkoutsUseCase: GetWorkoutsUseCase,
    private val mapper: WorkoutMapper,
) : ViewModel(), EventHandler<WorkoutListEvent> {
    private val _state = MutableLiveData(baseState)
    val state get() = _state

    private val handler = ExceptionHandler.coroutineExceptionHandler()

    override fun obtainEvent(event: WorkoutListEvent) {
        when (val currentState = _state.value) {
            is WorkoutListState.Loading -> reduce(event, currentState)
            is WorkoutListState.Display -> reduce(event, currentState)
            is WorkoutListState.Empty -> reduce(event, currentState)
            is WorkoutListState.Error -> reduce(event, currentState)
        }
    }

    private fun reduce(event: WorkoutListEvent, state: WorkoutListState.Loading) {
        when (event) {
            is WorkoutListEvent.Init -> loadWorkouts()
            else -> {}
        }
    }

    private fun reduce(event: WorkoutListEvent, state: WorkoutListState.Display) {
        when (event) {
            is WorkoutListEvent.Init -> {}
            is WorkoutListEvent.Filter -> filter(event.type, state)
            is WorkoutListEvent.Search -> search(event.text, state)
        }
    }

    private fun reduce(event: WorkoutListEvent, state: WorkoutListState.Error) {
        when (event) {
            is WorkoutListEvent.Init -> loadWorkoutsWithLoadState()
            else -> {}
        }
    }

    private fun reduce(event: WorkoutListEvent, state: WorkoutListState.Empty) {
        when (event) {
            is WorkoutListEvent.Init -> loadWorkoutsWithLoadState()
            else -> {}
        }
    }

    private fun loadWorkoutsWithLoadState() {
        _state.value = WorkoutListState.Loading
        loadWorkouts()
    }

    private fun loadWorkouts() = viewModelScope.launch(handler) {
        val workouts = getWorkoutsUseCase()
        _state.value = when (workouts) {
            is DataState.Success -> {
                val result = workouts.result.map(mapper::fromWorkoutToWorkoutUI)
                if (result.isEmpty()) {
                    WorkoutListState.Empty
                } else {
                    WorkoutListState.Display(
                        workouts = result,
                        displayWorkouts = result,
                        searchText = null,
                        workoutType = WorkoutTypeUI.All,
                    )
                }
            }

            is DataState.Error -> WorkoutListState.Error(
                workouts.error.message ?: "Unhandled Error"
            )
        }
    }

    private fun search(text: String, state: WorkoutListState.Display) {
        _state.value = filter(state.workoutType, text, state)
    }

    private fun filter(type: WorkoutTypeUI, state: WorkoutListState.Display) {
        _state.value = filter(type, state.searchText, state)
    }

    private fun filter(
        type: WorkoutTypeUI, text: String?, state: WorkoutListState.Display
    ): WorkoutListState.Display {
        val searchedWorkouts = if (text.isNullOrBlank()) {
            state.workouts
        } else {
            state.workouts.filter { it.title.contains(text) }
        }
        val filteredWorkouts = if (type == WorkoutTypeUI.All) {
            searchedWorkouts
        } else {
            searchedWorkouts.filter { it.type == type }
        }
        return state.copy(searchText = text, workoutType = type, displayWorkouts = filteredWorkouts)
    }
}
