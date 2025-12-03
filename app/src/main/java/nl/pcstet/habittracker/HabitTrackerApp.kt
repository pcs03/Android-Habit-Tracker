package nl.pcstet.habittracker

import android.app.Application
import nl.pcstet.habittracker.data.local.localDataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class HabitTrackerApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@HabitTrackerApp)
            modules(
                localDataModule,
            )
        }
    }
}