package info.metadude.kotlin.library.sessionize.gridtable.models

import com.squareup.moshi.JsonClass
import org.threeten.bp.ZonedDateTime

@JsonClass(generateAdapter = true)
data class Session(

        val categories: List<Category> = emptyList(),
        val description: String?,
        val endsAt: ZonedDateTime? = null,
        val id: String = "",
        val isPlenumSession: Boolean = false,
        val isServiceSession: Boolean = false,
        val room: String = "",
        val roomId: Int = 0,
        val speakers: List<Speaker> = emptyList(),
        val startsAt: ZonedDateTime? = null,
        val title: String = ""

)
