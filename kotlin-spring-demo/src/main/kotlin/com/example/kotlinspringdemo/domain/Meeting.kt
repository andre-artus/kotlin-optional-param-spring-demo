package com.example.kotlinspringdemo.domain

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias

@TypeAlias("meeting")
data class Meeting(
        @Id
        val id: String = ObjectId().toHexString(),
        val objective: String,
        val date: String

)

