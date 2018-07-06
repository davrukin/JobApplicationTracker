package net.davrukin.jobapplicationtracker.ui.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.davrukin.jobapplicationtracker.R
import net.davrukin.jobapplicationtracker.ui.viewmodels.NewJobApplicationViewModel

class NewJobApplicationFragment : Fragment() {

	companion object {
		fun newInstance() = NewJobApplicationFragment()
	}

	private lateinit var viewModel: NewJobApplicationViewModel

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
	                          savedInstanceState: Bundle?): View {
		return inflater.inflate(R.layout.new_job_application_fragment, container, false)
	}

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
		viewModel = ViewModelProviders.of(this).get(NewJobApplicationViewModel::class.java)
		// TODO: Use the ViewModel
	}

}
