package com.example.a20220608_evanjones_nycschools.view.activities

import android.content.Intent
import android.os.Bundle
import android.view.ContextThemeWrapper
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a20220608_evanjones_nycschools.R
import com.example.a20220608_evanjones_nycschools.di.SchoolApplication
import com.example.a20220608_evanjones_nycschools.model.School
import com.example.a20220608_evanjones_nycschools.model.VMData
import com.example.a20220608_evanjones_nycschools.model.repository.Repository
import com.example.a20220608_evanjones_nycschools.view.adapters.SchoolAdapter
import com.example.a20220608_evanjones_nycschools.viewmodel.SchoolViewModel
import com.example.a20220608_evanjones_nycschools.viewmodel.SchoolViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    //this allows dagger to supply an instance of the repository
    @Inject
    lateinit var repository: Repository
    private lateinit var schoolRV: RecyclerView
    private lateinit var schoolSearch: SearchView


    //this will let the data from the first view
    //persist to the next on click
    private val schoolAdapter: SchoolAdapter = SchoolAdapter(object: SchoolAdapter.OnSchoolClick{
      override fun openDetails(school: School){
          val nameData: String = school.school_name
          val testTakerData: String = school.num_of_sat_test_takers
          val mathData: String = school.sat_math_avg_score
          val readingData: String = school.sat_critical_reading_avg_score
          val writingData: String = school.sat_writing_avg_score

          Intent(this@MainActivity, SchoolDetailsActivity::class.java).also {
              it.putExtra("nameData", nameData)
              it.putExtra("testTakerData", testTakerData)
              it.putExtra("mathData", mathData)
              it.putExtra("readingData", readingData)
              it.putExtra("writingData", writingData)
              startActivity(it)
          }
    }
    })

    private val viewModelFactory by lazy{
        SchoolViewModelFactory(repository)
    }

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)
            .get(SchoolViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //this lets Dagger2 inject all the necessary dependencies during build time
        (applicationContext as SchoolApplication).applicationComponent.inject(this)

        schoolRV = findViewById(R.id.school_rv)
        schoolRV.apply{
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }

        schoolRV.adapter = schoolAdapter

        //makes the activity an observer of the ViewModel's livedata
        viewModel.schoolLiveData.observe(this,
            {
                when(it) {
                    is VMData.Response -> {
                        schoolAdapter.schools = it.response
                    }
                    is VMData.Error -> {
                        notifyOfError(it.error)
                    }
                }
        })

        viewModel.getSchoolResponse()

        //this is where the search gets implemented
        schoolSearch = findViewById(R.id.school_search)
        schoolSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                }
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                schoolAdapter.search(newText)
                return true
            }
    })
    }

    private fun notifyOfError(error: String) {
        AlertDialog.Builder(ContextThemeWrapper(this, R.style.ThemeOverlay_AppCompat))
            .setTitle(getString(R.string.error_title))
            .setMessage(error)
            .setPositiveButton("Ok") { dialog, _ ->
                dialog.dismiss()
            }.create().show()
    }
}