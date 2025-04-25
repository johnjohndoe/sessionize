package info.metadude.kotlin.library.sessionize

import info.metadude.kotlin.library.sessionize.gridtable.models.*
import kotlinx.coroutines.test.runTest
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.fail
import org.junit.jupiter.api.Test

class ProductionApiTest {

    companion object {
        const val BASE_URL = "https://sessionize.com"
        const val API_KEY = "rxafxyj8"
    }

    @Test
    fun `getConferenceDays responds successfully`() = runTest {
        try {
            val response = service.getConferenceDays(eTag = "", lastModifiedAt = "", API_KEY)
            when (response.isSuccessful) {
                true -> {
                    val conferenceDays = response.body()
                    assertThat(conferenceDays).isNotNull
                    conferenceDays?.forEach { assertConferenceDay(it) }
                }

                false -> {
                    fail("Request failed with code ${response.code()}: ${response.message()}")
                }
            }
        } catch (t: Throwable) {
            fail("Should not throw $t")
        }
    }

    private fun assertConferenceDay(conferenceDay: ConferenceDay) {
        assertNotNull(conferenceDay.date)
        assertNotNull(conferenceDay.rooms)
        conferenceDay.rooms.forEach {
            assertNotNull(it)
            assertRoom(it)
        }
        assertNotNull(conferenceDay.timeSlots)
        conferenceDay.timeSlots.forEach {
            assertNotNull(it)
            assertTimeSlot(it)
        }
    }

    private fun assertRoom(room: Room) {
        assertNotNull(room.hasOnlyPlenumSessions)
        assertNotNull(room.id)
        assertNotNull(room.name)
        assertNotNull(room.sessions)
        room.sessions.forEach {
            assertNotNull(it)
            assertSession(it)
        }
    }

    private fun assertSession(session: Session) {
        assertNotNull(session.categories)
        session.categories.forEach {
            assertNotNull(it)
            assertCategory(it)
        }
        //assertNotNull(session.description)
        assertNotNull(session.endsAt)
        assertNotNull(session.id)
        assertNotNull(session.isPlenumSession)
        assertNotNull(session.isServiceSession)
        assertNotNull(session.room)
        assertNotNull(session.roomId)
        assertNotNull(session.speakers)
        session.speakers.forEach {
            assertNotNull(it)
            assertSpeaker(it)
        }
        assertNotNull(session.startsAt)
        assertNotNull(session.title)
    }

    private fun assertCategory(category: Category) {
        assertNotNull(category.categoryItems)
        category.categoryItems.forEach {
            assertNotNull(it)
            assertCategoryItem(it)
        }
        assertNotNull(category.id)
        assertNotNull(category.name)
        assertNotNull(category.sort)
    }

    private fun assertCategoryItem(categoryItem: CategoryItem) {
        assertNotNull(categoryItem.id)
        assertNotNull(categoryItem.name)
    }

    private fun assertSpeaker(speaker: Speaker) {
        assertNotNull(speaker.id)
        assertNotNull(speaker.name)
    }

    private fun assertTimeSlot(timeSlot: TimeSlot) {
        assertNotNull(timeSlot.rooms)
        timeSlot.rooms.forEach {
            assertNotNull(it)
            assertTimeSlotRoom(it)
        }
        assertNotNull(timeSlot.slotStart)
    }

    private fun assertTimeSlotRoom(timeSlotRoom: TimeSlotRoom) {
        assertNotNull(timeSlotRoom.id)
        assertNotNull(timeSlotRoom.index)
        assertNotNull(timeSlotRoom.name)
        assertNotNull(timeSlotRoom.session)
        assertSession(timeSlotRoom.session)
    }

    private fun assertNotNull(it: Any?) = assertThat(it).isNotNull

    private val service: SessionizeService by lazy {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BASIC
        val okHttpClient = OkHttpClient.Builder()
                .addNetworkInterceptor(interceptor)
                .build()
        ApiModule.provideSessionizeService(BASE_URL, okHttpClient)
    }

}
