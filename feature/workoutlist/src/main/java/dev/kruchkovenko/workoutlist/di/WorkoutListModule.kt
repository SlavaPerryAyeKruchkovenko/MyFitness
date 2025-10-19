package dev.kruchkovenko.workoutlist.di

import dev.kruchkovenko.workoutlist.mapper.WorkoutMapper
import dev.kruchkovenko.workoutlist.mapper.WorkoutMapperImpl
import dev.kruchkovenko.workoutlist.model.WorkoutState
import dev.kruchkovenko.workoutlist.presentation.WorkoutListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

object WorkoutListModule {
    val workoutListModule = module {
        single<WorkoutMapper> {
            WorkoutMapperImpl()
        }
        viewModel<WorkoutListViewModel> {
            WorkoutListViewModel(
                baseState = WorkoutState.Loading,
                getWorkoutsUseCase = get(),
                mapper = get()
            )
        }
    }
}
