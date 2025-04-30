package info.metadude.kotlin.library.sessionize.adapters

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneId
import org.threeten.bp.ZonedDateTime


class ZonedDateTimeAdapterTest {

    private val adapter = ZonedDateTimeAdapter()

    @Test
    fun `Converts a valid zoned datetime Z into its string representation`() {
        val date = ZonedDateTime.of(LocalDateTime.of(2017, 11, 2, 9, 0, 0), ZoneId.of("Z"))
        val actual = adapter.toJson(date)
        assertThat(actual).isEqualTo("2017-11-02T09:00:00Z")
    }

    @Test
    fun `Converts a valid zoned datetime UTC into its string representation`() {
        val date = ZonedDateTime.of(LocalDateTime.of(2017, 11, 2, 9, 0, 0), ZoneId.of("UTC"))
        val actual = adapter.toJson(date)
        assertThat(actual).isEqualTo("2017-11-02T09:00:00Z")
    }

    @Test
    fun `Converts a valid datetime string into a zoned datetime object Z`() {
        val actual = adapter.fromJson("2017-11-02T09:00:00Z")
        val expected = ZonedDateTime.of(LocalDateTime.of(2017, 11, 2, 9, 0, 0), ZoneId.of("Z"))
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `Converts a valid datetime string into a zoned datetime object UTC`() {
        val actual = adapter.fromJson("2017-11-02T09:00:00Z")
        val expected = ZonedDateTime.of(LocalDateTime.of(2017, 11, 2, 9, 0, 0), ZoneId.of("UTC"))
        assertThat(actual?.toInstant()).isEqualTo(expected.toInstant())
    }

    @Test
    fun `Converts a date string to null`() {
        assertThat(adapter.fromJson("2016-12-27")).isEqualTo(null)
    }

    @Test
    fun `Converts an local datetime string to null`() {
        assertThat(adapter.fromJson("2016-12-27T08:15:05.674")).isEqualTo(null)
    }

    @Test
    fun `Converts an empty string to null`() {
        val actual = adapter.fromJson("")
        assertThat(actual).isEqualTo(null)
    }

    @Test
    fun `Converts null to null`() {
        val actual = adapter.fromJson(null)
        assertThat(actual).isEqualTo(null)
    }

}
