package dev.kruchkovenko.workoutlist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.kruchkovenko.core.utils.ExceptionHandler
import dev.kruchkovenko.domain.model.DataState
import dev.kruchkovenko.domain.usecase.GetWorkoutsUseCase
import dev.kruchkovenko.workoutlist.mapper.WorkoutMapper
import dev.kruchkovenko.workoutlist.model.WorkoutState
import dev.kruchkovenko.workoutlist.model.WorkoutTypeUI
import kotlinx.coroutines.launch

class WorkoutListViewModel(
    baseState: WorkoutState,
    private val getWorkoutsUseCase: GetWorkoutsUseCase,
    private val mapper: WorkoutMapper,
) : ViewModel() {
    private val _state = MutableLiveData(baseState)
    val state get() = _state

    private val handler = ExceptionHandler.coroutineExceptionHandler()

    fun loadWorkouts() = viewModelScope.launch(handler) {
        val workouts = getWorkoutsUseCase()
        _state.value = when (workouts) {
            is DataState.Success -> {
                val result = workouts.result.map(mapper::fromWorkoutToWorkoutUI)
                WorkoutState.Display(
                    workouts = result,
                    displayWorkouts = result,
                    searchText = null,
                    workoutType = WorkoutTypeUI.All,
                )
            }

            is DataState.Error -> WorkoutState.Error(workouts.error.message ?: "Unhandled Error")
        }
    }

    fun search(text: String) {

    }

    fun filter(type: WorkoutTypeUI) {

    }
}
