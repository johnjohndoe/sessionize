package info.metadude.kotlin.library.sessionize

import com.squareup.moshi.Moshi
import info.metadude.kotlin.library.sessionize.adapters.LocalDateTimeAdapter
import okhttp3.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Api : SessionizeApi {

    override fun provideSessionizeService(baseUrl: String, callFactory: Call.Factory): SessionizeService {
        require(baseUrl.isNotEmpty()) { "baseUrl is empty." }
        return createRetrofit(baseUrl, callFactory).create(SessionizeService::class.java)
    }

    private fun createRetrofit(baseUrl: String, callFactory: Call.Factory): Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(MoshiConverterFactory.create(provideMoshiBuilder()))
                .callFactory(callFactory)
                .build()
    }

    private fun provideMoshiBuilder(): Moshi {
        return Moshi.Builder()
            .add(LocalDateTimeAdapter())
            .build()
    }

}
