package dev.kruchkovenko.domain.usecase

import dev.kruchkovenko.domain.model.DataState
import dev.kruchkovenko.domain.model.Workout

interface GetWorkoutsUseCase {
    suspend operator fun invoke(): DataState<List<Workout>>
}
