package info.metadude.kotlin.library.sessionize.adapters

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import org.threeten.bp.DateTimeException
import org.threeten.bp.ZonedDateTime
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.DateTimeParseException

class ZonedDateTimeAdapter {

    private val dateTimeFormatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME!!

    @FromJson
    fun fromJson(text: String?) = text?.let {
        try {
            ZonedDateTime.parse(text, dateTimeFormatter)
        } catch (_: DateTimeParseException) {
            null
        }
    }

    @ToJson
    fun toJson(dateTime: ZonedDateTime?) = dateTime?.let {
        try {
            it.format(dateTimeFormatter)
        } catch (_: DateTimeException) {
            null
        }
    }

}
