package info.metadude.kotlin.library.sessionize

private const val kotlinVersion = "1.3.40"

object GradlePlugins {

    private object Versions {
        const val gradleBintray = "1.8.4"
        const val gradleVersions = "0.27.0"
    }

    const val gradleBintray = "com.jfrog.bintray.gradle:gradle-bintray-plugin:${Versions.gradleBintray}"
    const val gradleVersions = "com.github.ben-manes:gradle-versions-plugin:${Versions.gradleVersions}"
    const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
}

object Libs {

    private object Versions {
        const val assertjCore = "3.10.0"
        const val junitJupiter = "5.5.2"
        const val kotlinCoroutinesRetrofit = "1.1.0"
        const val moshi = "1.8.0"
        const val okhttp = "3.12.5"
        const val retrofit = "2.6.2"
        const val threetenbp = "1.4.0"
    }

    const val assertjCore = "org.assertj:assertj-core:${Versions.assertjCore}"
    const val junitJupiterApi = "org.junit.jupiter:junit-jupiter-api:${Versions.junitJupiter}"
    const val junitJupiterEngine = "org.junit.jupiter:junit-jupiter-engine:${Versions.junitJupiter}"
    const val kotlinCoroutinesRetrofit = "ru.gildor.coroutines:kotlin-coroutines-retrofit:${Versions.kotlinCoroutinesRetrofit}"
    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"
    const val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
    const val moshiKotlinCodegen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val okhttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitMoshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val threetenbp = "org.threeten:threetenbp:${Versions.threetenbp}"
}
