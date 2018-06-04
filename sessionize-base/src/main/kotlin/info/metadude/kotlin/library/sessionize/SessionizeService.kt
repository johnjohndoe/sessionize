package info.metadude.kotlin.library.sessionize

import info.metadude.kotlin.library.sessionize.gridtable.models.ConferenceDay
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SessionizeService {

    @GET("api/v2/{apiKey}/view/gridtable")
    fun getConferenceDays(@Path("apiKey") apiKey: String): Call<List<ConferenceDay>>

}
