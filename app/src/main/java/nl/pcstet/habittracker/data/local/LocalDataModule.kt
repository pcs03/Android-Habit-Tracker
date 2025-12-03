package nl.pcstet.habittracker.data.local

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val localDataModule = module {
    single<HabitDataBase> { HabitDataBase.getDatabase(androidContext()) }
}