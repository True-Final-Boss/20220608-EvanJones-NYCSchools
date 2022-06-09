package com.example.a20220608_evanjones_nycschools.di

import android.app.Application

class SchoolApplication : Application(){
    val applicationComponent: ApplicationComponent = DaggerApplicationComponent.create()
}