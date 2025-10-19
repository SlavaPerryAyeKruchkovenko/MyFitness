package dev.kruchkovenko.core.di

import dev.kruchkovenko.core.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.Protocol
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object CoreModule {
    val coreModule = module {
        single<OkHttpClient> {
            OkHttpClient.Builder()
                .followRedirects(true)
                .protocols(listOf(Protocol.HTTP_1_1))
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build()
        }
        single<Retrofit> {
            Retrofit.Builder()
                .baseUrl(getProperty<String>(Constants.BASE_URL))
                .addConverterFactory(GsonConverterFactory.create())
                .client(get())
                .build()
        }
    }
}
