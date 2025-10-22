package dev.kruchkovenko.domain.usecase.`interface`

import dev.kruchkovenko.domain.model.DataState
import dev.kruchkovenko.domain.model.Video

interface GetVideoUseCase {
    suspend operator fun invoke(id: Int): DataState<Video?>
}
