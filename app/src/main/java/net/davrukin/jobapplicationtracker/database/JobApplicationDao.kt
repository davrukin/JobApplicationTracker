package net.davrukin.jobapplicationtracker.database

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery
import io.reactivex.Flowable
import net.davrukin.jobapplicationtracker.models.JobApplication
import net.davrukin.jobapplicationtracker.models.ApplicationStatus
import net.davrukin.jobapplicationtracker.models.Offer

@Dao
interface JobApplicationDao {

    // TODO: make sure these don't occur on the main thread

    @Insert
    fun insert(ja: JobApplication)

    @Update
    fun update(ja: JobApplication)

    @Delete
    fun delete(ja: JobApplication)

    @Query("SELECT * FROM job_application")
    fun getAllJobApplications(): LiveData<List<JobApplication>>

    @Query("SELECT * FROM job_application WHERE company LIKE :company")
    fun findJobApplicationsByCompany(company: String): LiveData<List<JobApplication>>
        // TODO: figure out how livedata works and if it is a list structure itself

    @Query("SELECT * FROM job_application WHERE position LIKE :position")
    fun findJobApplicationsWithPosition(position: String): LiveData<List<JobApplication>>

    @Query("SELECT * FROM job_application WHERE status LIKE :status")
    fun findJobApplicationsWithStatus(status: ApplicationStatus): LiveData<List<JobApplication>>

    @Query("SELECT * FROM job_application WHERE offer LIKE :offer")
    fun findJobApplicationsWithOffer(offer: Offer): LiveData<List<JobApplication>>

    @RawQuery
    fun getJobApplicationViaQuery(query: SupportSQLiteQuery): LiveData<JobApplication>

}