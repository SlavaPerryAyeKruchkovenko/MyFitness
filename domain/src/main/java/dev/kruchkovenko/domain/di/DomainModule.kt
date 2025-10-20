package dev.kruchkovenko.domain.di

import dev.kruchkovenko.domain.usecase.GetVideoUseCaseImpl
import dev.kruchkovenko.domain.usecase.`interface`.GetWorkoutsUseCase
import dev.kruchkovenko.domain.usecase.GetWorkoutsUseCaseImpl
import dev.kruchkovenko.domain.usecase.`interface`.GetVideoUseCase
import org.koin.dsl.module

object DomainModule {
    val domainModule = module {
        single<GetWorkoutsUseCase> {
            GetWorkoutsUseCaseImpl(repository = get())
        }
        single<GetVideoUseCase> {
            GetVideoUseCaseImpl(repository = get())
        }
    }
}
