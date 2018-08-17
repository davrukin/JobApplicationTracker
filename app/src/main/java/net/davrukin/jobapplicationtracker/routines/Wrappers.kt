package net.davrukin.jobapplicationtracker.routines

import androidx.lifecycle.LiveData
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import net.davrukin.jobapplicationtracker.models.ApplicationStatus
import net.davrukin.jobapplicationtracker.models.JobApplication
import net.davrukin.jobapplicationtracker.JobApplicationTracker
import net.davrukin.jobapplicationtracker.models.Offer
import net.davrukin.jobapplicationtracker.models.User

class Wrappers {

    // get user stored in system, don't need to constantly pass it in

    private val user: User?= null

    init {
        //this.user =
    }


    object Users {

        fun addApplicationToUser(user: User, app: JobApplication) {
            user.applications
        }

        fun getApplicationsFromUser(user: User): LiveData<MutableList<JobApplication>> {
            return user.applications
        }

        fun byUser(): LiveData<User>? {
            return JobApplicationTracker.db
                    ?.userDao()
                    ?.getUser()
        }
    }

    object JobApplications {

        fun byCompany(company: String): LiveData<List<JobApplication>>? {
            return JobApplicationTracker.db
                    ?.jobApplicationDao()
                    ?.findJobApplicationsByCompany(company)
        }

        fun withPosition(position: String): LiveData<List<JobApplication>>? {
            return JobApplicationTracker.db
                    ?.jobApplicationDao()
                    ?.findJobApplicationsWithPosition(position)
        }

        object ApplicationsByStatus {
            fun appliedTo(): LiveData<List<JobApplication>>? {
                return jobApplicationByStatus(ApplicationStatus.APPLIED)
            }

            fun initialNo(): LiveData<List<JobApplication>>? {
                return jobApplicationByStatus(ApplicationStatus.INITIAL_NO)
            }

            fun phoneScreen(): LiveData<List<JobApplication>>? {
                return jobApplicationByStatus(ApplicationStatus.INVITATION_TO_PHONE_SCREEN)
            }

            fun codingChallenge(): LiveData<List<JobApplication>>? {
                return jobApplicationByStatus(ApplicationStatus.CODING_CHALLENGE)
            }

            fun onSite(): LiveData<List<JobApplication>>? {
                return jobApplicationByStatus(ApplicationStatus.ON_SITE_INTERVIEW)
            }

            fun offer(): LiveData<List<JobApplication>>? {
                return jobApplicationByStatus(ApplicationStatus.OFFER)

            }

            private fun jobApplicationByStatus(status: ApplicationStatus): LiveData<List<JobApplication>>? {
                return JobApplicationTracker.db
                        ?.jobApplicationDao()
                        ?.findJobApplicationsWithStatus(status)
            }
        }

        object ApplicationsByOffer {
            fun getApplicationsWithOffer(): LiveData<List<JobApplication>>? {
                return jobApplicationByOffer(Offer(true))
            }

            fun getApplicationsWithoutOffer(): LiveData<List<JobApplication>>? {
                return jobApplicationByOffer(Offer(false))
            }

            private fun jobApplicationByOffer(offer: Offer): LiveData<List<JobApplication>>? {
                return JobApplicationTracker.db
                        ?.jobApplicationDao()
                        ?.findJobApplicationsWithOffer(offer)
            }
        }
    }
}