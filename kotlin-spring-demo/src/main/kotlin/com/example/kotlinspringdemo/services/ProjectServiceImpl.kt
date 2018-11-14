package com.example.kotlinspringdemo.services

import com.example.kotlinspringdemo.data.ProjectRepository
import com.example.kotlinspringdemo.domain.Project
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service("projectService")
class ProjectServiceImpl : ProjectService {
    @Autowired
    lateinit var projectRepository: ProjectRepository

    override fun findById(id: ObjectId) = projectRepository.findById(id)
    override fun findAll(): List<Project> = projectRepository.findAll()
    override fun createProject(project: Project) = projectRepository.insert(project)
    override fun createProjects(projects: MutableIterable<Project>): MutableList<Project> = projectRepository.insert(projects)
    override fun updateProject(project: Project) = projectRepository.save(project)
    override fun deleteProject(id: ObjectId) = projectRepository.deleteById(id)
}