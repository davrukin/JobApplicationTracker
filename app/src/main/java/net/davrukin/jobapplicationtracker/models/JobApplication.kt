package net.davrukin.jobapplicationtracker.models

import androidx.lifecycle.LiveData
import androidx.room.Entity
import androidx.room.PrimaryKey
import net.davrukin.jobapplicationtracker.models.ApplicationStatus
import net.davrukin.jobapplicationtracker.models.Offer

/**
 * Enter company as string, position as string, application status as enum, and offer as enum
 */
@Entity(tableName = "job_application")
data class JobApplication(
    @PrimaryKey var company: LiveData<String>,
    var position: LiveData<String>,
    var status: LiveData<ApplicationStatus>, // enum
    var offer: LiveData<Offer>
)