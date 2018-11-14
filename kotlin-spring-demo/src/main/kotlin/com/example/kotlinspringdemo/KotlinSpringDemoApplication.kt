package com.example.kotlinspringdemo

import com.example.kotlinspringdemo.data.ProjectRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class KotlinSpringDemoApplication {
    @Bean
    fun initiatingProcess(repo: ProjectRepository) = CommandLineRunner {
        println("========== Clear all entities ==========")
        repo.deleteAll()
    }
}

fun main(args: Array<String>) {
    runApplication<KotlinSpringDemoApplication>(*args)
}
