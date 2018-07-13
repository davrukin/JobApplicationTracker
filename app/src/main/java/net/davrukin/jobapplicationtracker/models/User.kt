package net.davrukin.jobapplicationtracker.models

import androidx.lifecycle.LiveData
import androidx.room.PrimaryKey
import androidx.room.Entity

/**
 * Enter User as name and list of applications
 */
@Entity(tableName = "user")
data class User(
    @PrimaryKey var name: LiveData<String>,
    var applications: LiveData<MutableList<JobApplication>>
)