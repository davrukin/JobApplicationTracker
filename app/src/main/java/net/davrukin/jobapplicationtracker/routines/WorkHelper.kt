package net.davrukin.jobapplicationtracker.routines

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import androidx.work.*
import java.util.concurrent.TimeUnit

/**
 * Based on tutorial from: https://developer.android.com/topic/libraries/architecture/workmanager
 */
class WorkHelper {

	private var worker: OneTimeWorkRequest ?= null
	private var lifecycleOwner: LifecycleOwner ?= null

	init {
		worker = OneTimeWorkRequestBuilder<Workers>().build()
		lifecycleOwner = LifecycleOwner()
	}

	fun startWork() {
		WorkManager.getInstance()!!.enqueue(worker)
	}

	fun cancelTask() {
		WorkManager.getInstance()!!.cancelWorkById(worker!!.id)
	}

	fun getStatus() {
		WorkManager.getInstance()!!.getStatusById(worker!!.id)
			.observe(lifecycleOwner, Observer { workStatus ->
				if (workStatus != null && workStatus.state.isFinished) {
					// do something
				}
			})
	}

	fun setConstraints() {
		val myConstraints = Constraints.Builder()
				//.setRequiresDeviceIdle(true)
				.setRequiresCharging(true)
				.build()

		val work = OneTimeWorkRequestBuilder<Workers>().setConstraints(myConstraints).build()
	}

	fun runPeriodicTask() {
		val builder = PeriodicWorkRequestBuilder<Workers>(12, TimeUnit.HOURS)
		val work = builder.build()
		WorkManager.getInstance()!!.enqueue(work)
	}

	fun runChainedTasks() {
		val myConstraints1 = Constraints.Builder()
				//.setRequiresDeviceIdle(true)
				.setRequiresCharging(true)
				.build()

		val myConstraints2 = Constraints.Builder()
				//.setRequiresDeviceIdle(true)
				.setRequiresBatteryNotLow(true)
				.build()

		val myConstraints3 = Constraints.Builder()
				//.setRequiresDeviceIdle(true)
				.setRequiresStorageNotLow(true)
				.build()

		val work1 = OneTimeWorkRequestBuilder<Workers>().build()
		val work2 = OneTimeWorkRequestBuilder<Workers>().setConstraints(myConstraints1).addTag("work2").build()
		val work3 = OneTimeWorkRequestBuilder<Workers>().setConstraints(myConstraints2).build()
		val work4 = OneTimeWorkRequestBuilder<Workers>().setConstraints(myConstraints3).addTag("work4").build()
		val work5 = OneTimeWorkRequestBuilder<Workers>().build()

		WorkManager.getInstance()!!
			// runs all these first in parallel
			.beginWith(work1, work2, work3)
			// when those are finished, run these
			.then(work4)
			// then run these in any order
			.then(work4, work5)
			// start the work
			.enqueue()

		// can also combine chains
		val chain1 = WorkManager.getInstance()!!.beginWith(work1, work2, work3).then(work4).then(work4, work5)
		val chain2 = WorkManager.getInstance()!!.beginWith(work1, work2, work3).then(work4).then(work4, work5)

		val chain3 = WorkContinuation
			// runs all work in chain1 then all work in chain 2, not in parallel
			// certain work in chain1 may overlap with chain2
			// more details in the docs
			.combine(chain1, chain2)
			// can also do work once chains have been combined
			.then(work1)
			// start the chain
			.enqueue()

		// can also check status of chain or work
		println(chain2.statuses.value)
	}

	fun runWorkWithParameters(userID: String, jamID: String) {
		val myData: Data = mapOf("ARG_USER_ID" to userID, "ARG_JAM_ID" to jamID).toWorkData()

		val myDataWork = OneTimeWorkRequestBuilder<Workers>().setInputData(myData).build()

		WorkManager.getInstance()!!.enqueue(myDataWork)

		// now get the result data
		WorkManager.getInstance()!!.getStatusById(myDataWork.id)
				.observe(this, Observer { status ->
					if (status != null && status.state.isFinished) {
						val myResult = status.outputData.getString("RESULT_KEY", "")
						println("myResult: $myResult")
					}
				})
	}
}