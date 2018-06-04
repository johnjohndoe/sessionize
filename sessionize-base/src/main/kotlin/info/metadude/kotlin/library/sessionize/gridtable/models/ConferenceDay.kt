package info.metadude.kotlin.library.sessionize.gridtable.models

import com.squareup.moshi.JsonClass
import org.threeten.bp.LocalDateTime

@JsonClass(generateAdapter = true)
data class ConferenceDay(

        val date: LocalDateTime = LocalDateTime.MIN,
        val rooms: List<Room> = emptyList(),
        val timeSlots: List<TimeSlot> = emptyList()

)
