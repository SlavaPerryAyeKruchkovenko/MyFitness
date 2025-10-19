package dev.kruchkovenko.data.di

import dev.kruchkovenko.data.mapper.WorkoutMapper
import dev.kruchkovenko.data.mapper.WorkoutMapperImpl
import dev.kruchkovenko.data.network.WorkoutApi
import dev.kruchkovenko.data.repository.WorkoutRepositoryImpl
import dev.kruchkovenko.domain.repository.WorkoutRepository
import org.koin.dsl.module
import retrofit2.Retrofit

object DataModule {
    val dataModule = module {
        single<WorkoutMapper> {
            WorkoutMapperImpl()
        }
        single<WorkoutApi> { get<Retrofit>().create(WorkoutApi::class.java) }
        single<WorkoutRepository> {
            WorkoutRepositoryImpl(api = get(), mapper = get())
        }
    }
}
