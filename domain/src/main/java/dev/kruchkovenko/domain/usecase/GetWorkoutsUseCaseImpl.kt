package dev.kruchkovenko.domain.usecase

import dev.kruchkovenko.domain.model.DataState
import dev.kruchkovenko.domain.model.Workout
import dev.kruchkovenko.domain.repository.WorkoutRepository

class GetWorkoutsUseCaseImpl(private val repository: WorkoutRepository) : GetWorkoutsUseCase {
    override suspend operator fun invoke(): DataState<List<Workout>> {
        return repository.getWorkouts()
    }
}
