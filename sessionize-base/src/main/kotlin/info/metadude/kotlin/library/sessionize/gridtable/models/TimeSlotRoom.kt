package info.metadude.kotlin.library.sessionize.gridtable.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TimeSlotRoom(

        val id: Int = 0,
        val index: Int = 0,
        val name: String = "",
        val session: Session

)
