package dev.kruchkovenko.domain.usecase.`interface`

import dev.kruchkovenko.domain.model.DataState
import dev.kruchkovenko.domain.model.Workout

interface GetWorkoutsUseCase {
    suspend operator fun invoke(): DataState<List<Workout>>
}
