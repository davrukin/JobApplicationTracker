package net.davrukin.jobapplicationtracker.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.list.rados.fast_list.bind
import com.list.rados.fast_list.update
import net.davrukin.jobapplicationtracker.R
import net.davrukin.jobapplicationtracker.R.id.*
import net.davrukin.jobapplicationtracker.R.layout.job_application_item
import net.davrukin.jobapplicationtracker.models.ApplicationStatus
import net.davrukin.jobapplicationtracker.models.JobApplication
import net.davrukin.jobapplicationtracker.models.Offer
import net.davrukin.jobapplicationtracker.ui.viewmodels.StartViewModel
import kotlinx.android.synthetic.main.job_application_item.view.*
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.start_fragment.*
import net.davrukin.jobapplicationtracker.extensions.bind
import net.davrukin.jobapplicationtracker.ui.viewadapters.RecyclerViewAdapter

//import com.list.rados.fast_list.bind

class StartFragment : Fragment() { // for some reason not working as NavHostFragment()

    companion object {
        fun newInstance() = StartFragment()
    }

	private lateinit var buttonAddJobApp: Button
    private lateinit var viewModel: StartViewModel
	private lateinit var linearLayoutManager: LinearLayoutManager
	private lateinit var recyclerView: RecyclerView
	private lateinit var recyclerViewAdapter: RecyclerViewAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
	    /*button_add_job_app.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.newJobApplicationFragment, savedInstanceState))
		recyclerView = recycler_view
	    setUpRecyclerView2()*/

        return inflater.inflate(R.layout.start_fragment, container, false)
    }

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
		viewModel = ViewModelProviders.of(this).get(StartViewModel::class.java)
		// TODO: Use the ViewModel

		buttonAddJobApp = button_add_job_app
		buttonAddJobApp.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.newJobApplicationFragment, savedInstanceState))
		recyclerView = recycler_view
		linearLayoutManager = LinearLayoutManager(this.context)
		recyclerView.layoutManager = linearLayoutManager
		setUpRecyclerView2()
	}

	/**
	 * Using FastList
	 *
	 * Simple Single Layout List With No Layout
	 */
	private fun setUpRecyclerView() {
		val list = listOf<String>("pizza", "hamburger", "hotdog", "antelope", "lion", "tiger")
		//recyclerView.bind(list)
	}

	/**
	 * Using FastList
	 *
	 * Simple Single Layout List with Custom Layout
	 */
	private fun setUpRecyclerView2() {
		//val list = listOf<String>("pizza", "hamburger", "hotdog", "antelope", "lion", "tiger")
		val apple = MutableLiveData<String>();                apple.value =     "Apple"
		val google = MutableLiveData<String>();               google.value =    "Google"
		val microsoft = MutableLiveData<String>();            microsoft.value = "Microsoft"
		val linkedin = MutableLiveData<String>();             linkedin.value =  "LinkedIn"
		val hp = MutableLiveData<String>();                   hp.value =        "HP"

		val se = MutableLiveData<String>();                   se.value =        "Software Engineer"
		val sre = MutableLiveData<String>();                  sre.value =       "Site  Reliability Engineer"
		val oe = MutableLiveData<String>();                   oe.value =        "Office Engineer"
		val ubw = MutableLiveData<String>();                  ubw.value =       "LinkedIn"
		val sa = MutableLiveData<String>();                   sa.value =        "Spectre Agent"

		val a = MutableLiveData<ApplicationStatus>();         a.value =         ApplicationStatus.APPLIED
		val cc = MutableLiveData<ApplicationStatus>();        cc.value =        ApplicationStatus.CODING_CHALLENGE
		val ino = MutableLiveData<ApplicationStatus>();       ino.value =       ApplicationStatus.INITIAL_NO
		val one = MutableLiveData<ApplicationStatus>();       one.value =       ApplicationStatus.ON_SITE_INTERVIEW
		val o = MutableLiveData<ApplicationStatus>();         o.value =         ApplicationStatus.OFFER

		val t = MutableLiveData<Offer>();                     t.value =         Offer(true)
		val f = MutableLiveData<Offer>();                     f.value =         Offer(false)

		val ja1 = JobApplication(apple, se, a, f)
		val ja2 = JobApplication(google, sre, cc, f)
		val ja3 = JobApplication(microsoft, oe, ino, f)
		val ja4 = JobApplication(linkedin, ubw, one, f)
		val ja5 = JobApplication(hp, sa, o, t)
		// what are the performance overheads with all these LiveData objects?
		val list2 = listOf<JobApplication>(ja1, ja2, ja3, ja4, ja5)

		recyclerViewAdapter = RecyclerViewAdapter(list2)
		recyclerView.adapter = recyclerViewAdapter

		/*recyclerView.bind(list2, job_application_item) { ja: JobApplication ->
			textView_company.text = ja.company.value
			textView_position.text = ja.position.value
			textView_status.text = ja.status.value!!.name
			textView_offer.text = ja.offer.value!!.given.toString()
			// TODO: click on card, if clicked, show more details like offer info
			// TODO: ability to compare offers or other company attributes
		}*/
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

}
