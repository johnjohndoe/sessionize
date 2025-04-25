package info.metadude.kotlin.library.sessionize.repositories

import info.metadude.kotlin.library.sessionize.repositories.models.GetConferenceDaysState
import kotlinx.coroutines.flow.Flow

interface SessionizeRepository {

    suspend fun getConferenceDaysState(
        requestETag: String,
        lastModifiedAt: String,
    ): Flow<GetConferenceDaysState>

}
