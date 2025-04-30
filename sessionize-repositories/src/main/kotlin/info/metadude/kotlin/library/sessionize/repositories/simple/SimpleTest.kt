package info.metadude.kotlin.library.sessionize.repositories.simple

import info.metadude.kotlin.library.sessionize.Api
import kotlinx.coroutines.flow.collectLatest
import okhttp3.OkHttpClient

internal suspend fun main() {
    val repository = SimpleSessionizeRepository(
        baseUrl = "https://sessionize.com",
        apiKey = "oleuq4yu",
        callFactory = OkHttpClient.Builder().build(),
        api = Api,
    )

    repository.getConferenceDaysState(requestETag = "", lastModifiedAt = "").collectLatest {
        println("$it")
    }
    println("Done.")
}
