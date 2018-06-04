package info.metadude.kotlin.library.sessionize.gridtable.models

import com.squareup.moshi.JsonClass
import org.threeten.bp.LocalDateTime

@JsonClass(generateAdapter = true)
data class Session(

        val categories: List<Category> = emptyList(),
        val description: String?,
        val endsAt: LocalDateTime = LocalDateTime.MIN,
        val id: String = "",
        val isPlenumSession: Boolean = false,
        val isServiceSession: Boolean = false,
        val room: String = "",
        val roomId: Int = 0,
        val speakers: List<Speaker> = emptyList(),
        val startsAt: LocalDateTime = LocalDateTime.MIN,
        val title: String = ""

)
