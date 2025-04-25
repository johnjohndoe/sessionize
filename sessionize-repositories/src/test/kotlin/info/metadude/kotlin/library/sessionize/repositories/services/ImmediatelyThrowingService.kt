package info.metadude.kotlin.library.sessionize.repositories.services

import info.metadude.kotlin.library.sessionize.SessionizeService
import info.metadude.kotlin.library.sessionize.gridtable.models.ConferenceDay
import retrofit2.Response

class ImmediatelyThrowingService : SessionizeService {

    override suspend fun getConferenceDays(
        eTag: String,
        lastModifiedAt: String,
        apiKey: String,
    ): Response<List<ConferenceDay>> =
        throw RuntimeException()

}
