package info.metadude.kotlin.library.sessionize.repositories.simple

import info.metadude.kotlin.library.sessionize.SessionizeApi
import info.metadude.kotlin.library.sessionize.repositories.SessionizeRepository
import info.metadude.kotlin.library.sessionize.repositories.models.GetConferenceDaysState
import info.metadude.kotlin.library.sessionize.repositories.models.GetConferenceDaysState.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.Call

class SimpleSessionizeRepository(
    private val baseUrl: String,
    private val apiKey: String,
    private val callFactory: Call.Factory,
    private val api: SessionizeApi,
) : SessionizeRepository {

    private companion object {
        const val HEADER_NAME_ETAG = "ETag"
        const val HEADER_NAME_LAST_MODIFIED = "Last-Modified"
    }

    override suspend fun getConferenceDaysState(requestETag: String, lastModifiedAt: String): Flow<GetConferenceDaysState> {
        return flow {
            val emission = try {
                val response = api
                    .provideSessionizeService(baseUrl, callFactory)
                    .getConferenceDays(requestETag, lastModifiedAt, apiKey)
                if (response.isSuccessful) {
                    Success(
                        conferenceDays = response.body().orEmpty(),
                        responseETag = response.headers()[HEADER_NAME_ETAG].orEmpty(),
                        responseLastModifiedAt = response.headers()[HEADER_NAME_LAST_MODIFIED].orEmpty(),
                    )
                } else {
                    val errorMessage = response.errorBody()?.string() ?: response.message().orEmpty()
                    Error(
                        httpStatusCode = response.code(),
                        errorMessage = errorMessage,
                    )
                }
            } catch (t: Throwable) {
                Failure(throwable = t)
            }
            emit(emission)
        }
    }

}
