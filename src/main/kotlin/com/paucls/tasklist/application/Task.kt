package com.paucls.tasklist.application

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Task(
        @Id
        val id: String,
        val name: String,
        val userId: String,
        val done: Boolean = false
)