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
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.start_fragment.*
import net.davrukin.jobapplicationtracker.R
import net.davrukin.jobapplicationtracker.ui.viewmodels.StartViewModel
import com.list.rados.fast_list.bind
import com.list.rados.fast_list.update
import kotlinx.android.synthetic.main.job_application_item.view.*
import net.davrukin.jobapplicationtracker.R.layout.job_application_item
import net.davrukin.jobapplicationtracker.extensions.bind
import net.davrukin.jobapplicationtracker.models.ApplicationStatus
import net.davrukin.jobapplicationtracker.models.JobApplication
import net.davrukin.jobapplicationtracker.models.Offer

class StartFragment : Fragment() { // for some reason not working as NavHostFragment()

    companion object {
        fun newInstance() = StartFragment()
    }

    private lateinit var viewModel: StartViewModel
	private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
	    button_add_job_app.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.newJobApplicationFragment, savedInstanceState))
		recyclerView = recycler_view
	    setUpRecyclerView2()

        return inflater.inflate(R.layout.start_fragment, container, false)
    }

	/**
	 * Using FastList
	 *
	 * Simple Single Layout List With No Layout
	 */
	private fun setUpRecyclerView() {
		val list = listOf<String>("pizza", "hamburger", "hotdog", "antelope", "lion", "tiger")
		recyclerView.bind(list)
	}

	/**
	 * Using FastList
	 *
	 * Simple Single Layout List with Custom Layout
	 */
	private fun setUpRecyclerView2() {
		//val list = listOf<String>("pizza", "hamburger", "hotdog", "antelope", "lion", "tiger")
		val ja1 = JobApplication("Apple", "Software Engineer", ApplicationStatus.APPLIED, Offer(false))
		val ja2 = JobApplication("Google", "Site Reliability Engineer", ApplicationStatus.CODING_CHALLENGE, Offer(false))
		val ja3 = JobApplication("Microsoft", "Office Engineer", ApplicationStatus.INITIAL_NO, Offer(false))
		val ja4 = JobApplication("LinkedIn", "Underwater Basket Weaver", ApplicationStatus.ON_SITE_INTERVIEW, Offer(false))
		val ja5 = JobApplication("HP", "Spectre Agent", ApplicationStatus.OFFER, Offer(true))
		val list2 = listOf<JobApplication>(ja1, ja2, ja3, ja4, ja5)
		recyclerView.bind(list2, job_application_item) { ja: JobApplication ->
			textView_company.text = ja.company
			textView_position.text = ja.position
			textView_status.text = ja.status.name
			textView_offer.text = ja.offer.given.toString()
			// TODO: click on card, if clicked, show more details like offer info
			// TODO: ability to compare offers or other company attributes
		}
	}

	/**
	 * Using FastList
	 *
	 * Dynamic List with Multiple Layouts
	 */
	private fun setUpRecyclerView3() {
		val list = listOf<String>("pizza", "hamburger", "hotdog", "antelope", "lion", "tiger")
		//recyclerView.bind(list).map()
	}

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(StartViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
