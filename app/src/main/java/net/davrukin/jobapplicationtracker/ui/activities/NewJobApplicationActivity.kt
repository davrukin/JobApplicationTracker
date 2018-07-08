package net.davrukin.jobapplicationtracker.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import net.davrukin.jobapplicationtracker.R
import net.davrukin.jobapplicationtracker.ui.fragments.NewJobApplicationFragment

class NewJobApplicationActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.new_job_application_activity)
		if (savedInstanceState == null) {
			supportFragmentManager.beginTransaction()
					.replace(R.id.container, NewJobApplicationFragment.newInstance())
					.commitNow()
		}
	}

	override fun onSupportNavigateUp(): Boolean {
		return super.onSupportNavigateUp()
	}

}
