package com.paucls.tasklist.persistence

import com.paucls.tasklist.application.Task
import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepository : JpaRepository<Task, String>
