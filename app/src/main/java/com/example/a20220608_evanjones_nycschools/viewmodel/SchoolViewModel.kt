package com.example.a20220608_evanjones_nycschools.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a20220608_evanjones_nycschools.model.VMData
import com.example.a20220608_evanjones_nycschools.model.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//ViewModel is critical for MVVM architecture
//viewmodel will have livedata for the objects that the views will observe
//it will also have a repository to retrieve data from the model layer

//this viewmodel will contain logic to retrieve, update, maintain data, as well as move
//tasks involving data logic to a background thread

class SchoolViewModel(
    val repository: Repository
) : ViewModel() {

    private val _schoolLiveData = MutableLiveData<VMData>()
    val schoolLiveData: LiveData<VMData>
        get() = _schoolLiveData

    //have a function to make our network call
    fun getSchoolResponse() {
        viewModelScope.launch(Dispatchers.IO) {

            try {
                val response = repository.getSchools()
                _schoolLiveData.postValue(VMData.Response(response))
            } catch(e: Exception){
                _schoolLiveData.postValue(VMData.Error(e.message?:e.localizedMessage))
            }
        }
    }
}