package com.example.kotlinspringdemo.domain

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "projects")
@TypeAlias("project")
data class Project(
        @Id
        val id: String = ObjectId().toHexString(),
        val name: String,
        val location: String,
        val date: String,
        val meetings: List<Meeting>?
)
