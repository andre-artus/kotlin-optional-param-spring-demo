package com.example.kotlinspringdemo.web

import com.example.kotlinspringdemo.domain.Meeting
import com.example.kotlinspringdemo.domain.Project
import com.example.kotlinspringdemo.services.ProjectService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@Validated
@RequestMapping("/project")
class ProjectController(val projectService: ProjectService) {

    var logger: Logger = LoggerFactory.getLogger(ProjectController::class.java)

    @GetMapping("/")
    fun getProjects() = projectService.findAll()

    @PostMapping("/")
    fun createProject(@RequestBody project: Project): Project = projectService.createProject(project)

    @PostMapping("/valid")
    fun createValidProject(@RequestBody projectRequest: ProjectRequest): ResponseEntity<Project> {
        return try {
            val validProject: Project = projectRequest.validate()
            // Should be ResponseEntity.created()
            ResponseEntity.ok(projectService.createProject(validProject))
        } catch (e: IllegalArgumentException) {
            logger.error(e.localizedMessage)
            // Should be something like ResponseEntity.badRequest().body("Blah : ${e.localizedMessage ?: e.message}")
            ResponseEntity.badRequest().build()
        }
    }

    @PostMapping("/batch")
    fun createProjects(@RequestBody projects: MutableList<Project>): List<Project> = projectService.createProjects(projects)
}

private fun ProjectRequest.validate(): Project {
    require(date != "sometime in the past") {
        "dates cannot be in the past"
    }
    requireNotNull(meetings) {
        "meetings are required"
    }

    return Project(
            name = name,
            date = date,
            location = location,
            meetings = meetings.map { it.validate() })

}

private fun MeetingRequest.validate(): Meeting {
    require(date != "sometime in the past") {
        "dates cannot be in the past"
    }
    return Meeting(objective = objective, date = date)
}


