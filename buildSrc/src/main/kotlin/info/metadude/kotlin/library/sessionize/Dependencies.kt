package info.metadude.kotlin.library.sessionize

private const val kotlinVersion = "2.1.20"

object GradlePlugins {

    private object Versions {
        const val gradleVersions = "0.52.0"
        const val ksp = "2.1.20-2.0.1"
    }

    const val gradleVersions = "com.github.ben-manes:gradle-versions-plugin:${Versions.gradleVersions}"
    const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val ksp = "com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin:${Versions.ksp}"
}

object Libs {

    private object Versions {
        const val assertjCore = "3.14.0"
        const val junitJupiter = "5.5.2"
        const val kotlinCoroutinesRetrofit = "1.1.0"
        const val moshi = "1.15.2"
        const val okhttp = "3.12.5"
        const val retrofit = "2.6.2"
        const val threetenbp = "1.7.1"
    }

    const val assertjCore = "org.assertj:assertj-core:${Versions.assertjCore}"
    const val junitJupiterApi = "org.junit.jupiter:junit-jupiter-api:${Versions.junitJupiter}"
    const val junitJupiterEngine = "org.junit.jupiter:junit-jupiter-engine:${Versions.junitJupiter}"
    const val kotlinCoroutinesRetrofit = "ru.gildor.coroutines:kotlin-coroutines-retrofit:${Versions.kotlinCoroutinesRetrofit}"
    const val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
    const val moshiKotlinCodegen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val okhttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitMoshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val threetenbp = "org.threeten:threetenbp:${Versions.threetenbp}"
}
