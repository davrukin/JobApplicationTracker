package net.davrukin.jobapplicationtracker.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import net.davrukin.jobapplicationtracker.models.JobApplication

@Database(entities = arrayOf(JobApplication::class), version = 1)
@TypeConverters(net.davrukin.jobapplicationtracker.database.TypeConverters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract var userDao: UserDao
    abstract var jobApplicationDao: JobApplicationDao

}