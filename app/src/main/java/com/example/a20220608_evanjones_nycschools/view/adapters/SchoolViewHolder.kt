package com.example.a20220608_evanjones_nycschools.view.adapters

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a20220608_evanjones_nycschools.R

//putting the response from the variables into
//a place where the user can see

class SchoolViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val schoolName: TextView = view.findViewById(R.id.school_name)
    val testTakers: TextView = view.findViewById(R.id.test_takers)


    fun bindData(context: Context, school_name: String, num_of_sat_test_takers: String){
        schoolName.text = school_name
        testTakers.text = num_of_sat_test_takers
    }
}