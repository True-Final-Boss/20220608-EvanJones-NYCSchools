package com.example.a20220608_evanjones_nycschools.model

import java.io.Serializable


//These variables are created to match the ones in the Json response
data class School (
    val school_name: String,
    val num_of_sat_test_takers: String,
    val sat_critical_reading_avg_score: String,
    val sat_math_avg_score: String,
    val sat_writing_avg_score: String

): Serializable