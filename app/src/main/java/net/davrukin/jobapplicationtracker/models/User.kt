package net.davrukin.jobapplicationtracker.models

import androidx.lifecycle.LiveData
import androidx.room.PrimaryKey
import androidx.room.Entity

@Entity(tableName = "user")
data class User(
    @PrimaryKey var name: String,
    var applications: LiveData<MutableList<JobApplication>>
)