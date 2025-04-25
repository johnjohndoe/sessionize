package info.metadude.kotlin.library.sessionize.repositories.simple

import app.cash.turbine.test
import info.metadude.kotlin.library.sessionize.SessionizeApi
import info.metadude.kotlin.library.sessionize.gridtable.models.ConferenceDay
import info.metadude.kotlin.library.sessionize.repositories.models.GetConferenceDaysState.*
import info.metadude.kotlin.library.sessionize.repositories.services.ImmediatelyFailingService
import info.metadude.kotlin.library.sessionize.repositories.services.ImmediatelySucceedingService
import info.metadude.kotlin.library.sessionize.repositories.services.ImmediatelyThrowingService
import kotlinx.coroutines.test.runTest
import okhttp3.Call
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock

class SimpleSessionizeRepositoryTest {

    private lateinit var api: SessionizeApi
    private val httpClient = mock<Call.Factory>()

    @Test
    fun `getConferenceDaysState() returns success with list of conference days`(): Unit = runTest {
        api = mock {
            on { provideSessionizeService("https://example.com", httpClient) }
                .doReturn(ImmediatelySucceedingService())
        }
        val repository = createRepository(api)
        repository.getConferenceDaysState(requestETag = "", lastModifiedAt = "").test {
            val actualState = awaitItem()
            assertThat(actualState).isInstanceOf(Success::class.java)
            val success = actualState as Success
            assertThat(success.conferenceDays).isEqualTo(listOf(ConferenceDay()))
            assertThat(success.responseETag).isEqualTo("")
            awaitComplete()
        }
    }

    @Test
    fun `getConferenceDaysState() returns failure with http error`(): Unit = runTest {
        api = mock {
            on { provideSessionizeService("https://example.com", httpClient) }
                .doReturn(ImmediatelyFailingService())
        }
        val repository = createRepository(api)
        repository.getConferenceDaysState(requestETag = "", lastModifiedAt = "").test {
            val actualState = awaitItem()
            assertThat(actualState).isInstanceOf(Error::class.java)
            val error = actualState as Error
            assertThat(error.httpStatusCode).isEqualTo(503)
            assertThat(error.errorMessage).isEqualTo("Service Unavailable.")
            awaitComplete()
        }
    }

    @Test
    fun `getConferenceDaysState() returns failure with runtime exception`(): Unit = runTest {
        api = mock {
            on { provideSessionizeService("https://example.com", httpClient) }
                .doReturn(ImmediatelyThrowingService())
        }
        val repository = createRepository(api)
        repository.getConferenceDaysState(requestETag = "", lastModifiedAt = "").test {
            val actualState = awaitItem()
            assertThat(actualState).isInstanceOf(Failure::class.java)
            val failure = actualState as Failure
            assertThat(failure.throwable).isInstanceOf(RuntimeException::class.java)
            awaitComplete()
        }
    }

    private fun createRepository(api: SessionizeApi) = SimpleSessionizeRepository(
        baseUrl = "https://example.com",
        apiKey = "some_api_key",
        callFactory = httpClient,
        api = api,
    )

}