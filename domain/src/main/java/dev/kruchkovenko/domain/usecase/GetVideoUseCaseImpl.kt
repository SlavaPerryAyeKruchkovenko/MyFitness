package dev.kruchkovenko.domain.usecase

import dev.kruchkovenko.domain.model.DataState
import dev.kruchkovenko.domain.model.Video
import dev.kruchkovenko.domain.repository.WorkoutRepository
import dev.kruchkovenko.domain.usecase.`interface`.GetVideoUseCase

class GetVideoUseCaseImpl(private val repository: WorkoutRepository) : GetVideoUseCase {
    override suspend operator fun invoke(id: Int): DataState<Video?> {
        return repository.getVideo(id)
    }
}
