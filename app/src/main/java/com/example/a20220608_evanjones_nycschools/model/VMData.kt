package com.example.a20220608_evanjones_nycschools.model

//Sealed classes are designed to be used when there are
//a very specific set of possible outcomes
//These outcomes are functionally different
//It works like a state machine
sealed class VMData {
    data class Response(val response: List<School>) : VMData()
    data class Error(val error: String) : VMData()
}