package com.example.a20220608_evanjones_nycschools.network

import com.example.a20220608_evanjones_nycschools.model.School
import retrofit2.http.GET

//use it to get endpoints
//this used a plain url, but
//it is possible to use @Query for different search terms
interface SchoolApiInterface {
    @GET("resource/f9bf-2cp4.json")
    suspend fun getSchoolResponse(): List<School>
}