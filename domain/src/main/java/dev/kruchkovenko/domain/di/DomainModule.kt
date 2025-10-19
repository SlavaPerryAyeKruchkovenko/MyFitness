package dev.kruchkovenko.domain.di

import dev.kruchkovenko.domain.usecase.GetWorkoutsUseCase
import dev.kruchkovenko.domain.usecase.GetWorkoutsUseCaseImpl
import org.koin.dsl.module

object DomainModule {
    val domainModule = module {
        single<GetWorkoutsUseCase> {
            GetWorkoutsUseCaseImpl(repository = get())
        }
    }
}
