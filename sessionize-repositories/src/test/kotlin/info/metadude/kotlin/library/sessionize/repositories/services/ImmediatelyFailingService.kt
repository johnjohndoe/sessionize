package info.metadude.kotlin.library.sessionize.repositories.services

import info.metadude.kotlin.library.sessionize.SessionizeService
import info.metadude.kotlin.library.sessionize.gridtable.models.ConferenceDay
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response

class ImmediatelyFailingService : SessionizeService {

    override suspend fun getConferenceDays(
        eTag: String,
        lastModifiedAt: String,
        apiKey: String,
    ): Response<List<ConferenceDay>> {
        val responseBody = "Service Unavailable.".toResponseBody("plain/text".toMediaType())
        return Response.error(503, responseBody)
    }

}
