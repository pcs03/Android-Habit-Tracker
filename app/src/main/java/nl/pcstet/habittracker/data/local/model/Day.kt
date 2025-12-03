package nl.pcstet.habittracker.data.local.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.Relation
import java.time.LocalDate
import java.time.LocalDateTime

@Entity(tableName = "days")
data class DayEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val date: LocalDate,
)

@Entity(
    tableName = "activities",
    foreignKeys = [
        ForeignKey(
            entity = DayEntity::class,
            parentColumns = ["id"],
            childColumns = ["dayId"],
            onDelete = ForeignKey.CASCADE,
        )
    ],
    indices = [
        Index("dayId"),
    ]
)
data class ActivityEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val dayId: Int,
    val name: String,
    val expectedStartTime: LocalDateTime,
    val actualStartTime: LocalDateTime? = null,
    val expectedEndTime: LocalDateTime? = null,
    val actualEndTime: LocalDateTime? = null,
)

data class DayWithActivitiesEntity(
    @Embedded val day: DayEntity,
    @Relation(
        entity = ActivityEntity::class,
        parentColumn = "id",
        entityColumn = "dayId",
    )
    val activities: List<ActivityEntity>,
)