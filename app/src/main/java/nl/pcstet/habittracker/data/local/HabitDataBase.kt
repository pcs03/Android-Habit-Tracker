package nl.pcstet.habittracker.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import nl.pcstet.habittracker.data.local.converters.DatabaseTypeConverters
import nl.pcstet.habittracker.data.local.model.ActivityEntity
import nl.pcstet.habittracker.data.local.model.DayEntity

@Database(entities = [DayEntity::class, ActivityEntity::class], version = 1)
@TypeConverters(DatabaseTypeConverters::class)
abstract class HabitDataBase : RoomDatabase() {
//    abstract fun

    companion object {
        @Volatile
        private var Instance: HabitDataBase? = null

        fun getDatabase(context: Context): HabitDataBase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, HabitDataBase::class.java, "habit_database")
                    .fallbackToDestructiveMigration(true)
                    .build()
                    .also { Instance = it }
            }
        }
    }
}
