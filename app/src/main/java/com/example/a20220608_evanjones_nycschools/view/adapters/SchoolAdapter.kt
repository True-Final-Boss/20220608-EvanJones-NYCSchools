package com.example.a20220608_evanjones_nycschools.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a20220608_evanjones_nycschools.R
import com.example.a20220608_evanjones_nycschools.model.School

class SchoolAdapter(private val onClick: OnSchoolClick): RecyclerView.Adapter<SchoolViewHolder>() {

    interface OnSchoolClick{
        fun openDetails(school: School)
    }
    var displayList: List<School> = listOf()

    var schools: List<School> = listOf()
        set(value) {
            field = value
            displayList = value
            notifyDataSetChanged()
        }

    //can search based on school name
    fun search(schoolName: String){
        displayList = if(schoolName.trim().isEmpty())
            schools
        else
            //this allows for not using initial caps to match names
            //basically just user friendliness
            schools.filter { it.school_name.lowercase().startsWith(schoolName.lowercase())}
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.school_item, parent, false)
        return SchoolViewHolder(view)
    }


    //takes the variables i created to match the json
    //and matches the proper case and position
    override fun onBindViewHolder(holder: SchoolViewHolder, position: Int) {
        val currentSchool = displayList[position]
        holder.bindData(holder.itemView.context,
            currentSchool.school_name,
            currentSchool.num_of_sat_test_takers)

        //allows clicking the individual schools
        holder.itemView.setOnClickListener{
            onClick.openDetails(currentSchool)
        }
    }

    override fun getItemCount(): Int {
        return displayList.size
    }
}