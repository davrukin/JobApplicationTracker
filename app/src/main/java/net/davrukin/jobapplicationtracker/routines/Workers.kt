package net.davrukin.jobapplicationtracker.routines

import androidx.work.Data
import androidx.work.Worker
import androidx.work.toWorkData

// parameter keys
const val ARG_USER_ID = "userID"
const val ARG_JAM_ID = "jamID"

// result key
const val RESULT_KEY = "result"

class Workers : Worker() {

	override fun doWork(): Result {

		val userID = inputData.getString(ARG_USER_ID)
		val jamID = inputData.getString(ARG_JAM_ID)

		val result = doSomething(userID!!, jamID!!)

		//val output: Data = mapOf(RESULT_KEY to result).toWorkData()
		//outputData = output // not working, fix later TODO: fix this

		return Result.SUCCESS

	}

	private fun doSomething(userID: String, jamID: String): String {
		val string = "userID: $userID; jamID: $jamID"
		println(string)
		return string
	}

}