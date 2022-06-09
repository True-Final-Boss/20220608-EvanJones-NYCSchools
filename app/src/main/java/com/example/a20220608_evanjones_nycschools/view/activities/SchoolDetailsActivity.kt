package com.example.a20220608_evanjones_nycschools.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.a20220608_evanjones_nycschools.R

class SchoolDetailsActivity : AppCompatActivity() {

    private val schoolIv: ImageView by lazy { findViewById(R.id.schoolIv) }
    private val tvName: TextView by lazy { findViewById(R.id.school_nameTv) }
    private val tvTTakers: TextView by lazy { findViewById(R.id.tTakersTV) }
    private val tvMath: TextView by lazy { findViewById(R.id.mathTV) }
    private val tvWriting: TextView by lazy { findViewById(R.id.writingTv) }
    private val tvReading: TextView by lazy { findViewById(R.id.readingTV) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_school_details)

        //and here is where the data that persisted from the main activity
        // will be received and applied to this activity
        intent?.let{
            schoolIv.setImageResource(R.drawable.nycopendata)
            tvName.text = intent.getStringExtra("nameData")
            tvTTakers.text = intent.getStringExtra("testTakerData")
            tvMath.text = intent.getStringExtra("mathData")
            tvWriting.text = intent.getStringExtra("writingData")
            tvReading.text = intent.getStringExtra("readingData")
        }

    }
}