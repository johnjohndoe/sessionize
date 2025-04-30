package info.metadude.kotlin.library.sessionize.gridtable.models

import com.squareup.moshi.JsonClass
import org.threeten.bp.ZonedDateTime

@JsonClass(generateAdapter = true)
data class ConferenceDay(

        val date: ZonedDateTime? = null,
        val rooms: List<Room> = emptyList(),
        val timeSlots: List<TimeSlot> = emptyList()

)
