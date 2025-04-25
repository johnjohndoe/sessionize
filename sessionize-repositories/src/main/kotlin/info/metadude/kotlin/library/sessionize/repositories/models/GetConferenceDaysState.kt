package info.metadude.kotlin.library.sessionize.repositories.models

import info.metadude.kotlin.library.sessionize.gridtable.models.ConferenceDay

sealed interface GetConferenceDaysState {

    data class Success(
        val conferenceDays: List<ConferenceDay>,
        val responseETag: String,
        val responseLastModifiedAt: String,
    ) : GetConferenceDaysState

    data class Error(
        val httpStatusCode: Int,
        val errorMessage: String,
    ) : GetConferenceDaysState

    data class Failure(
        val throwable: Throwable,
    ) : GetConferenceDaysState

}
