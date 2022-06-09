package com.example.a20220608_evanjones_nycschools.network

import com.example.a20220608_evanjones_nycschools.util.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//Retrofit makes it easy to retrieve and upload Json
//great for REST based webservice
//uses OKHttp library for http requests
class RetrofitClient {

    companion object {
        private val interceptor = HttpLoggingInterceptor().also {
            it.setLevel(HttpLoggingInterceptor.Level.BODY);
        }

        private val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()


        fun getService(): SchoolApiInterface {
            return retrofit.create(SchoolApiInterface ::class.java)
        }
    }
}