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
import net.davrukin.jobapplicationtracker.extensions.bind

class StartFragment : Fragment() { // for some reason not working as NavHostFragment()

    companion object {
        fun newInstance() = StartFragment()
    }

    private lateinit var viewModel: StartViewModel
	private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
	    button_add_job_app.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.newJobApplicationFragment, savedInstanceState))
		recyclerView = recycler_view
	    setUpRecyclerView()

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
		val list = listOf<String>("pizza", "hamburger", "hotdog", "antelope", "lion", "tiger")
		/*recyclerView.bind(list, ) {it : Item ->

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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(StartViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
