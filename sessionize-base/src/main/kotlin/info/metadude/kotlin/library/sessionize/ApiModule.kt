package info.metadude.kotlin.library.sessionize

import com.squareup.moshi.Moshi
import info.metadude.kotlin.library.sessionize.adapters.LocalDateTimeAdapter
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiModule {

    @JvmStatic
    fun provideSessionizeService(baseUrl: String, okHttpClient: OkHttpClient): SessionizeService =
            createRetrofit(baseUrl, okHttpClient).create(SessionizeService::class.java)

    private fun provideMoshiBuilder(): Moshi {
        return Moshi.Builder()
                .add(LocalDateTimeAdapter())
                .build()
    }

    private fun createRetrofit(baseUrl: String, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(MoshiConverterFactory.create(provideMoshiBuilder()))
                .client(okHttpClient)
                .build()
    }

}
