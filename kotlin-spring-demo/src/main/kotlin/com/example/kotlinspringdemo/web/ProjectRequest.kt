package com.example.kotlinspringdemo.web

data class ProjectRequest(
        val name: String,
        val location: String,
        val date: String,
        val meetings: List<MeetingRequest>?
)