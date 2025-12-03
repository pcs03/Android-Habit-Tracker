package nl.pcstet.habittracker.data.local.converters

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset

class DatabaseTypeConverters {
    @TypeConverter
    fun timestampToLocalDateTime(value: String?): LocalDateTime? {
        return value?.let { dateTimeString ->
            return LocalDateTime.parse(dateTimeString).atZone(ZoneOffset.UTC).withZoneSameInstant(
                ZoneId.systemDefault()).toLocalDateTime()
        }
    }

    @TypeConverter
    fun LocalDateTimeToTimestamp(date: LocalDateTime?): String? {
        return date?.toString()
    }

    @TypeConverter
    fun timestampToLocalDate(value: String?): LocalDate? {
        return value?.let { LocalDate.parse(it) }
    }

    @TypeConverter
    fun localDateToTimestamp(date: LocalDate?): String? {
        return date?.toString()
    }
}