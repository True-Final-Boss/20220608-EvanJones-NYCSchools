package com.example.a20220608_evanjones_nycschools.model.repository

import com.example.a20220608_evanjones_nycschools.model.School
import com.example.a20220608_evanjones_nycschools.network.RetrofitClient
import javax.inject.Inject
import javax.inject.Singleton

//this @Inject annotation lets Dagger2 know how to create this instance
//and that it needs to supply an instance of this class
@Singleton
class Repository @Inject constructor() {
    suspend fun getSchools(): List<School> {
        return RetrofitClient.getService().getSchoolResponse()
    }
}