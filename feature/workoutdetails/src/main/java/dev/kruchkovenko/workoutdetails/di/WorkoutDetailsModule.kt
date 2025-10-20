package dev.kruchkovenko.workoutdetails.di

import dev.kruchkovenko.workoutdetails.mapper.WorkoutMapper
import dev.kruchkovenko.workoutdetails.mapper.WorkoutMapperImpl
import dev.kruchkovenko.workoutdetails.model.WorkoutDetailsState
import dev.kruchkovenko.workoutdetails.presentation.WorkoutDetailsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

object WorkoutDetailsModule {
    val workoutListModule = module {
        single<WorkoutMapper> {
            WorkoutMapperImpl()
        }
        viewModel<WorkoutDetailsViewModel> {
            WorkoutDetailsViewModel(
                baseState = WorkoutDetailsState.Loading,
                mapper = get()
            )
        }
    }
}
