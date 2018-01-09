package com.paucls.tasklist.api

import com.paucls.tasklist.application.Task
import com.paucls.tasklist.application.TaskService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
class TaskController(val taskService: TaskService) {

    @RequestMapping("/")
    @ResponseBody
    fun home(): String {
        return "Task List API!"
    }

    @RequestMapping(value = ["/tasks"], method = [RequestMethod.GET])
    fun getAll(): ResponseEntity<List<Task>> {
        return ResponseEntity(taskService.getAll(), HttpStatus.OK)
    }

    @RequestMapping(value = ["/tasks"], method = [RequestMethod.POST])
    fun create(@RequestBody task: Task): ResponseEntity<Task> {
        return ResponseEntity(taskService.create(task), HttpStatus.CREATED)
    }

    @RequestMapping(value = ["/tasks/{taskId}"], method = [RequestMethod.DELETE])
    fun delete(@PathVariable taskId: String): ResponseEntity<Void> {
        taskService.delete(taskId)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

}