package net.davrukin.jobapplicationtracker.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import kotlinx.android.synthetic.main.start_fragment.*
import net.davrukin.jobapplicationtracker.R
import net.davrukin.jobapplicationtracker.ui.viewmodels.StartViewModel

class StartFragment : Fragment() { // for some reason not working as NavHostFragment()

    companion object {
        fun newInstance() = StartFragment()
    }

    private lateinit var viewModel: StartViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
	    button_add_job_app.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.newJobApplicationFragment, savedInstanceState))

        return inflater.inflate(R.layout.start_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(StartViewModel::class.java)
        // TODO: Use the ViewModel
    }



}
