package com.example.a20220608_evanjones_nycschools.di

import com.example.a20220608_evanjones_nycschools.model.repository.Repository
import com.example.a20220608_evanjones_nycschools.view.activities.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
//this annotation lets Dagger2 know that this is our application graph
// or container, etc.
@Component
interface ApplicationComponent {
    fun getRepository(): Repository

    fun inject(activity: MainActivity)
}