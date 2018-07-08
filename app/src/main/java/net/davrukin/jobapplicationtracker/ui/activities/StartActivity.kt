package net.davrukin.jobapplicationtracker.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavHost
import net.davrukin.jobapplicationtracker.R
import net.davrukin.jobapplicationtracker.routines.Wrappers
import net.davrukin.jobapplicationtracker.ui.fragments.StartFragment

class StartActivity : AppCompatActivity(), NavHost {

    override fun getNavController(): NavController {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, StartFragment.newInstance())
                    .commitNow()
        }

        println(Wrappers.JobApplications.byCompany("ACME"))
        println(Wrappers.JobApplications.ApplicationsByOffer.getApplicationsWithOffer())
        println(Wrappers.JobApplications.ApplicationsByOffer.getApplicationsWithoutOffer())
        println(Wrappers.JobApplications.ApplicationsByStatus.appliedTo())
        println(Wrappers.JobApplications.ApplicationsByStatus.codingChallenge())
        println(Wrappers.JobApplications.ApplicationsByStatus.initialNo())
        println(Wrappers.JobApplications.ApplicationsByStatus.offer())
        println(Wrappers.JobApplications.ApplicationsByStatus.onSite())
        println(Wrappers.JobApplications.ApplicationsByStatus.phoneScreen())
        println(Wrappers.JobApplications.withPosition("Software Engineer"))

    }

	override fun onSupportNavigateUp(): Boolean {
		return super.onSupportNavigateUp()
	}
}
