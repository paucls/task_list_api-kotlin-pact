package com.paucls.tasklist.application

import com.paucls.tasklist.persistence.TaskRepository
import org.springframework.stereotype.Service

@Service
class TaskService(val taskRepository: TaskRepository) {

    fun getAll(): List<Task> {
        return taskRepository.findAll()
    }

    fun delete(taskId: String) {
        taskRepository.deleteById(taskId)
    }

}