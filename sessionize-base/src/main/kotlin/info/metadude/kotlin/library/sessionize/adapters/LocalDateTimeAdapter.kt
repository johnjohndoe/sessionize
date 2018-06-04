package info.metadude.kotlin.library.sessionize.adapters

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import org.threeten.bp.DateTimeException
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.DateTimeParseException

class LocalDateTimeAdapter {

    private val dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME!!

    @FromJson
    fun fromJson(text: String?) = text?.let {
        try {
            LocalDateTime.parse(text, dateTimeFormatter)
        } catch (e: DateTimeParseException) {
            null
        }
    }

    @ToJson
    fun toJson(dateTime: LocalDateTime?) = dateTime?.let {
        try {
            it.format(dateTimeFormatter)
        } catch (e: DateTimeException) {
            null
        }
    }

}
