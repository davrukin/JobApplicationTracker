package net.davrukin.jobapplicationtracker.database

import androidx.lifecycle.LiveData
import androidx.room.TypeConverter
import com.google.common.reflect.TypeToken
import com.google.gson.Gson
import net.davrukin.jobapplicationtracker.models.ApplicationStatus
import net.davrukin.jobapplicationtracker.models.JobApplication
import net.davrukin.jobapplicationtracker.models.Offer
import net.davrukin.jobapplicationtracker.models.User

class TypeConverters {

	// convert JobApplication()
	// convert ApplicationStatus()
	// convert Offer()
	// convert User()

	/**
	 * Type converter for JobApplication
	 */
	@TypeConverter
	fun fromJobApplication(ja: JobApplication): String {
		return toJsonString(ja)
	}

	/**
	 * Type converter for JobApplication
	 */
	@TypeConverter
	fun toJobApplication(json: String): JobApplication {
		val type = object : TypeToken<JobApplication>(){}.type
		return Gson().fromJson(json, type)
	}

	/**
	 * Type converter for ApplicationStatus
	 */
	@TypeConverter
	fun fromApplicationStatus(aps: ApplicationStatus): String {
		return toJsonString(aps)
	}

	/**
	 * Type converter for ApplicationStatus
	 */
	@TypeConverter
	fun toApplicationStatus(json: String): ApplicationStatus {
		val type = object : TypeToken<ApplicationStatus>(){}.type
		return Gson().fromJson(json, type)
	}

	/**
	 * Type converter for Offer
	 */
	@TypeConverter
	fun fromOffer(offer: Offer): String {
		return toJsonString(offer)
	}

	/**
	 * Type converter for Offer
	 */
	@TypeConverter
	fun toOffer(json: String): Offer {
		val type = object : TypeToken<Offer>(){}.type
		return Gson().fromJson(json, type)
	}

	/**
	 * Type converter for User
	 */
	@TypeConverter
	fun fromUser(user: User): String {
		return toJsonString(user)
	}

	/**
	 * Type converter for User
	 */
	@TypeConverter
	fun toUser(json: String): User {
		val type = object : TypeToken<User>(){}.type
		return Gson().fromJson(json, type)
	}

	private fun toJsonString(o: Any): String {
		val gson = Gson()
		val json = gson.toJson(o)
		return json
	}

	// LiveData<> of String(), JobApplication(), ApplicationStatus(), Offer(), User()

	/**
	 * Type converter for LiveData<JobApplication>
	 */
	@TypeConverter
	fun fromJobApplicationLiveData(ja: LiveData<JobApplication>): String {
		return toJsonString(ja)
	}

	/**
	 * Type converter for LiveData<JobApplication>
	 */
	@TypeConverter
	fun toJobApplicationLiveData(json: String): LiveData<JobApplication> {
		val type = object : TypeToken<LiveData<JobApplication>>(){}.type
		return Gson().fromJson(json, type)
	}

	/**
	 * Type converter for LiveData<ApplicationStatus>
	 */
	@TypeConverter
	fun fromApplicationStatusLiveData(ja: LiveData<ApplicationStatus>): String {
		return toJsonString(ja)
	}

	/**
	 * Type converter for LiveData<ApplicationStatus>
	 */
	@TypeConverter
	fun toApplicationStatusLiveData(json: String): LiveData<ApplicationStatus> {
		val type = object : TypeToken<LiveData<ApplicationStatus>>(){}.type
		return Gson().fromJson(json, type)
	}

	/**
	 * Type converter for LiveData<Offer>
	 */
	@TypeConverter
	fun fromOfferLiveData(ja: LiveData<Offer>): String {
		return toJsonString(ja)
	}

	/**
	 * Type converter for LiveData<Offer>
	 */
	@TypeConverter
	fun toOfferLiveData(json: String): LiveData<Offer> {
		val type = object : TypeToken<LiveData<Offer>>(){}.type
		return Gson().fromJson(json, type)
	}

	/**
	 * Type converter for LiveData<String>
	 */
	@TypeConverter
	fun fromStringLiveData(ja: LiveData<String>): String {
		return toJsonString(ja)
	}

	/**
	 * Type converter for LiveData<String>
	 */
	@TypeConverter
	fun toStringLiveData(json: String): LiveData<String> {
		val type = object : TypeToken<LiveData<String>>(){}.type
		return Gson().fromJson(json, type)
	}
}