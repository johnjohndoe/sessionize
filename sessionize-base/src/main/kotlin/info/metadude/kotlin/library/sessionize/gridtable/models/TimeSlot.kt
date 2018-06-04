package info.metadude.kotlin.library.sessionize.gridtable.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TimeSlot(

        val rooms: List<TimeSlotRoom> = emptyList(),
        val slotStart: String = ""

)
