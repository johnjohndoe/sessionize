package info.metadude.kotlin.library.sessionize

import info.metadude.kotlin.library.sessionize.gridtable.models.ConferenceDay
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface SessionizeService {

    @GET("api/v2/{apiKey}/view/gridtable")
    suspend fun getConferenceDays(
        @Header("If-None-Match") eTag: String,
        @Header("If-Modified-Since") lastModifiedAt: String,
        @Path("apiKey") apiKey: String
    ): Response<List<ConferenceDay>>

}
