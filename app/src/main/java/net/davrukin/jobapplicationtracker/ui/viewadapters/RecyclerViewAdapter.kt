package net.davrukin.jobapplicationtracker.ui.viewadapters

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.job_application_item.view.*
import net.davrukin.jobapplicationtracker.R
import net.davrukin.jobapplicationtracker.extensions.inflate
import net.davrukin.jobapplicationtracker.models.JobApplication
import net.davrukin.jobapplicationtracker.ui.viewmodels.NewJobApplicationViewModel

/**
 * https://developer.android.com/guide/topics/ui/layout/recyclerview
 */
class RecyclerViewAdapter(private val items: List<JobApplication>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

	// Provide a reference to the views for each data item
	// Complex data items may need more than one view per item, and
	// you provide access to all the views for a data item in a view holder.
	// Each data item is just a string in this case that is shown in a TextView.
	class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

		override fun onClick(p0: View?) {
			TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
		}

		// company, position, offer, status
		// id = $textView_*

		var tvCompany: TextView
		var tvPosition: TextView
		var tvOffer: TextView
		var tvStatus: TextView

		lateinit var jaViewModel: JobApplication

		init {
			tvCompany = view.textView_company
			tvPosition = view.textView_position
			tvOffer = view.textView_offer
			tvStatus = view.textView_status
		}

		fun bind(jaViewModel: JobApplication) {
			this.jaViewModel = jaViewModel

			this.tvCompany.text = jaViewModel.company.value
			this.tvPosition.text = jaViewModel.position.value
			this.tvOffer.text = jaViewModel.offer.value!!.given.toString()
			this.tvStatus.text = jaViewModel.status.value.toString()
		}

	}

	/**
	 * Called when RecyclerView needs a new [ViewHolder] of the given type to represent
	 * an item.
	 *
	 *
	 * This new ViewHolder should be constructed with a new View that can represent the items
	 * of the given type. You can either create a new View manually or inflate it from an XML
	 * layout file.
	 *
	 *
	 * The new ViewHolder will be used to display items of the adapter using
	 * [.onBindViewHolder]. Since it will be re-used to display
	 * different items in the data set, it is a good idea to cache references to sub views of
	 * the View to avoid unnecessary [View.findViewById] calls.
	 *
	 * @param parent The ViewGroup into which the new View will be added after it is bound to
	 * an adapter position.
	 * @param viewType The view type of the new View.
	 *
	 * @return A new ViewHolder that holds a View of the given view type.
	 * @see .getItemViewType
	 * @see .onBindViewHolder
	 */
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.ViewHolder {
		val inflatedView = parent.inflate(R.layout.job_application_item, false)
		return ViewHolder(inflatedView)
	}

	/**
	 * Called by RecyclerView to display the data at the specified position. This method should
	 * update the contents of the [ViewHolder.itemView] to reflect the item at the given
	 * position.
	 *
	 *
	 * Note that unlike [android.widget.ListView], RecyclerView will not call this method
	 * again if the position of the item changes in the data set unless the item itself is
	 * invalidated or the new position cannot be determined. For this reason, you should only
	 * use the `position` parameter while acquiring the related data item inside
	 * this method and should not keep a copy of it. If you need the position of an item later
	 * on (e.g. in a click listener), use [ViewHolder.getAdapterPosition] which will
	 * have the updated adapter position.
	 *
	 * Override [.onBindViewHolder] instead if Adapter can
	 * handle efficient partial bind.
	 *
	 * @param holder The ViewHolder which should be updated to represent the contents of the
	 * item at the given position in the data set.
	 * @param position The position of the item within the adapter's data set.
	 */
	override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
		val ja: JobApplication = items[position]
		holder.bind(ja)
	}

	/**
	 * Returns the total number of items in the data set held by the adapter.
	 *
	 * @return The total number of items in this adapter.
	 */
	override fun getItemCount(): Int {
		return items.size
	}

}