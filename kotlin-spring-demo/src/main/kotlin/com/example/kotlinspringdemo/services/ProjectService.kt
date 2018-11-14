package com.example.kotlinspringdemo.services

import com.example.kotlinspringdemo.domain.Project
import org.bson.types.ObjectId
import java.util.*

interface ProjectService {
    fun findById(id: ObjectId): Optional<Project>
    fun findAll(): List<Project>
    fun createProject(project: Project): Project
    fun updateProject(project: Project): Project
    fun deleteProject(id: ObjectId)
    fun createProjects(projects: MutableIterable<Project>): MutableList<Project>
}