package net.davrukin.jobapplicationtracker.database

import androidx.room.Database
import androidx.room.RoomDatabase
import net.davrukin.jobapplicationtracker.models.JobApplication

@Database(entities = arrayOf(JobApplication::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract var userDao: UserDao
    abstract var jobApplicationDao: JobApplicationDao

}