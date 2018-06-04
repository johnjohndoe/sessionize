package info.metadude.kotlin.library.sessionize.gridtable.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Room(

        val hasOnlyPlenumSessions: Boolean = false,
        val id: Int = 0,
        val name: String = "",
        val sessions: List<Session> = emptyList()

)
