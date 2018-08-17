package net.davrukin.jobapplicationtracker

import android.app.Application
import androidx.multidex.MultiDexApplication
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import net.davrukin.jobapplicationtracker.database.AppDatabase

class JobApplicationTracker : MultiDexApplication() {

    companion object {
        var db: AppDatabase ?= null
    }

    override fun onCreate() {
        super.onCreate()
        JobApplicationTracker.db = Room.databaseBuilder(this.applicationContext,
                        AppDatabase::class.java, "applications.db")
                        //.addMigrations(MIGRATION_1_2)
                        //.fallbackToDestructiveMigration() // if migrations not necessary
                        .build()
    }


    /*private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE job_application ADD COLUMN address STRING")
        }
    }*/
}