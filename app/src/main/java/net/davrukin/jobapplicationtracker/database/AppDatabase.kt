package net.davrukin.jobapplicationtracker.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import net.davrukin.jobapplicationtracker.models.JobApplication
import net.davrukin.jobapplicationtracker.models.User

@Database(entities = [(User::class), (JobApplication::class)], version = 1)
@TypeConverters(net.davrukin.jobapplicationtracker.database.TypeConverters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun jobApplicationDao(): JobApplicationDao

}