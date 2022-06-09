package com.example.a20220608_evanjones_nycschools.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.a20220608_evanjones_nycschools.model.repository.Repository

//here's a modelClass which will be the reference to the ViewModel
//and return it with appropriate arguments
class SchoolViewModelFactory(val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Repository::class.java)
            .newInstance(repository)
    }


}