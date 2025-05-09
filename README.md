[![Build](https://github.com/johnjohndoe/sessionize/actions/workflows/build.yaml/badge.svg)](https://github.com/johnjohndoe/sessionize/actions/workflows/build.yaml) [![Build Status](https://app.travis-ci.com/johnjohndoe/sessionize.svg?token=UPoEhXykQ9pcGiExgqsH&branch=master)](https://app.travis-ci.com/johnjohndoe/sessionize) [![Apache License](http://img.shields.io/badge/license-Apache%20License%202.0-lightgrey.svg)](http://choosealicense.com/licenses/apache-2.0/) [![JitPack](https://jitpack.io/v/johnjohndoe/sessionize.svg)][jitpack-sessionize]

# Sessionize library

A Kotlin library containing a parser and models for the Sessionize API:

* https://sessionize.com/api-documentation

### Usage

The library is published as two separate artifacts: `sessionize-base` and `sessionize-repositories`.
You can use either of them depending on your needs.

#### Usage of `sessionize-base`

The `sessionize-base` artifact returns a `Response<List<ConferenceDay>>` type
from the suspending `SessionizeService#getConferenceDays` function.

```kotlin
val api: SessionizeApi = Api
val service: SessionizeService = api.provideSessionizeService(
    baseUrl = "https://sessionize.com",
    callFactory = okHttpClient,
)

val requestETag = "" // Pass an empty string or a previous ETag value for caching
val requestLastModifiedAt = "" // Pass an empty string or a previous Last-Modified value for caching
val response = service.getConferenceDays(
    eTag = requestETag,
    lastModifiedAt = requestLastModifiedAt,
    apiKey = "some_api_key",
)

if (response.isSuccessful) {
    val conferenceDays = response.body()
    val responseETag = response.headers()["ETag"]
    val responseLastModifiedAt = response.headers()["Last-Modified"]
} else {
    val errorCode = response.code()
    val errorMessage = response.message()
}
```

#### Usage of `sessionize-repositories`

The `sessionize-repositories` artifact returns a `Flow<GetConferenceDaysState>` type
from the suspending `SessionizeRepository#getConferenceDaysState` function.

```kotlin
val repository: SessionizeRepository = SimpleSessionizeRepository(
    baseUrl = "https://sessionize.com",
    apiKey = "some_api_key",
    callFactory = okHttpClient,
    api = Api,
)

val requestETag = "" // Pass an empty string or a previous ETag value for caching
val requestLastModifiedAt = "" // Pass an empty string or a previous Last-Modified value for caching
repository.getConferenceDaysState(
    requestETag = requestETag,
    lastModifiedAt = requestLastModifiedAt,
)
.collectLatest { state: GetConferenceDaysState ->
    when (state) {
        is Success -> {
            val conferenceDays = state.conferenceDays
            val responseETag = state.responseETag
            val responseLastModifiedAt = state.responseLastModifiedAt
        }
        is Error -> {
            val httpStatusCode = state.httpStatusCode
            val errorMessage = state.errorMessage
        }
        is Failure -> {
            val throwable = state.throwable
        }
    }
}
```


### Gradle build

To deploy the library to your local Maven repository run the following task:

```bash
$ ./gradlew publishToMavenLocal
```

Then, to use the library in your project add the following to
your top level `build.gradle`:

```
allprojects {
    repositories {
        mavenLocal()
    }
}
```

and one of the following dependencies to your application module `build.gradle`:


```groovy
dependencies {
    implementation "info.metadude.kotlin.library.sessionize:sessionize-base:$version"
    implementation "info.metadude.kotlin.library.sessionize:sessionize-repositories:$version"
}
```

Alternatively, you can use [JitPack][jitpack-sessionize] to fetch and
build the sources directly from this repository.


## Tests

Run the following command to execute all tests:

```groovy
$ ./gradlew clean test
```

## Author

* [Tobias Preuss][tobias-preuss]

## License

    Copyright 2018-2025 Tobias Preuss

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


[jitpack-sessionize]: https://jitpack.io/#johnjohndoe/sessionize
[tobias-preuss]: https://github.com/johnjohndoe
