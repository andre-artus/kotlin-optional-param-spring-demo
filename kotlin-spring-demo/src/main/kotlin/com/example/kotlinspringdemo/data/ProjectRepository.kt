package com.example.kotlinspringdemo.data

import com.example.kotlinspringdemo.domain.Project
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface ProjectRepository : MongoRepository<Project, ObjectId>
