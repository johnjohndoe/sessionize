package info.metadude.kotlin.library.sessionize.repositories.services

import info.metadude.kotlin.library.sessionize.SessionizeService
import info.metadude.kotlin.library.sessionize.gridtable.models.ConferenceDay
import retrofit2.Response
import retrofit2.Response.success

class ImmediatelySucceedingService : SessionizeService {

    override suspend fun getConferenceDays(
        eTag: String,
        lastModifiedAt: String,
        apiKey: String,
    ): Response<List<ConferenceDay>> =
        success(listOf(ConferenceDay()))

}
