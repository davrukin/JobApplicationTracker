package net.davrukin.jobapplicationtracker.ui.start

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room

class StartViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private val _data = MutableLiveData<String>()
    val data: LiveData<String> get() = _data

    init {
        _data.value = "Hello, Jetpack!"


    }
}
