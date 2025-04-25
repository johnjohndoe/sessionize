package info.metadude.kotlin.library.sessionize

import okhttp3.Call

interface SessionizeApi {

    fun provideSessionizeService(
        baseUrl: String,
        callFactory: Call.Factory,
    ): SessionizeService

}
