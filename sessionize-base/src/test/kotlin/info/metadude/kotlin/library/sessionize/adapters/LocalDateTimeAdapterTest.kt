package info.metadude.kotlin.library.sessionize.adapters

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.threeten.bp.LocalDateTime


class LocalDateTimeAdapterTest {

    private val adapter = LocalDateTimeAdapter()

    @Test
    fun `Converts a valid datetime into its string representation`() {
        val date = LocalDateTime.of(2017, 11, 2, 9, 0, 0)
        val actual = adapter.toJson(date)
        assertThat(actual).isEqualTo("2017-11-02T09:00:00")
    }

    @Test
    fun `Converts a valid datetime string into a date object`() {
        val actual = adapter.fromJson("2017-11-02T09:00:00")
        val expected = LocalDateTime.of(2017, 11, 2, 9, 0, 0)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `Converts a date string to null`() {
        assertThat(adapter.fromJson("2016-12-27")).isEqualTo(null)
    }

    @Test
    fun `Converts an offset datetime string to null`() {
        assertThat(adapter.fromJson("2016-12-27T08:15:05.674+01:00")).isEqualTo(null)
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
