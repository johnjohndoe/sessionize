# Sessionize changelog

## [v.4.0.0](https://github.com/johnjohndoe/sessionize/releases/tag/v.4.0.0)

* Published: 2025-05-02

### Changes

* **API change:** Dates are now provides as zoned date time.
  * Affected properties:
    * `ConferenceDay#date`
    * `Session#endsAt`
    * `Session#startsAt`
* **New:** Add `SimpleSessionizeRepository` in separate "sessionize-repositories" library artifact.
* **Breaking changes:**
  * Rename `ApiModule` to `Api`.
  * Change `Api#provideSessionizeService` parameter from `okHttpClient: OkHttpClient` to `callFactory: Call.Factory`.
  * Add `SessionizeApi` interface to `Api` to ease testing.
  * Require `baseUrl` parameter in `Api#provideSessionizeService` not to be empty string.
* **Breaking change:** Let `SessionizeService#getConferenceDays` return `Response<List<ConferenceDay>>`.
  * Add `eTag` and `lastModifiedAt` parameters.
  * Expose `retrofit2.Response` in library API.
* Add maven central deployment via `com.vanniktech.maven.publish` plugin.
* Use retrofit:2.11.0.
* Use okhttp:4.12.0.
* Use threetenbp:1.4.0.
* **Breaking changes:** Update project setup.
  * Target JDK 17.
  * Use gradle:8.13.
  * Use kotlin:2.1.20.
  * Use ksp:2.1.20-2.0.0.
  * Use moshi:1.15.2.
  * Use gradle-versions-plugin:0.52.0.
* Remove jcenter/bintray deployment.


## [v.3.0.0](https://github.com/johnjohndoe/sessionize/releases/tag/v.3.0.0)

* Published: 2019-11-21

### Changes

* Use assertj-core v.3.14.0.
* Use kotlin v.1.3.50.
* Use moshi v.1.9.1.
* Use retrofit v.2.6.2.
* Use okhttp v.3.12.5.
* Use junit-jupiter v.5.5.2.
* Use Gradle wrapper v.5.6.4.
* Use gradle-versions-plugin v.0.27.0.


## [v.2.0.0](https://github.com/johnjohndoe/sessionize/releases/tag/v.2.0.0)

* Published: 2019-06-23

### Changes

* Use junit-jupiter v.5.4.2.
* Use kotlin-coroutines-retrofit v.1.1.0.
* Use kotlin v.1.3.40.
* Use retrofit v.2.6.0.
* Use okhttp v.3.12.3.
* Use moshi v.1.8.0.
* Use threetenbp v.1.4.0.
* Use gradle-versions-plugin v.0.21.0.
* Use Gradle wrapper v.5.4.1.


## [v.1.0.0](https://github.com/johnjohndoe/sessionize/releases/tag/v.1.0.0)

* Published: 2018-09-27

### Changes

* This is the initial release. Have fun!
