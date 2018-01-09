package com.paucls.tasklist.provider

import au.com.dius.pact.provider.junit.Provider
import au.com.dius.pact.provider.junit.RestPactRunner
import au.com.dius.pact.provider.junit.State
import au.com.dius.pact.provider.junit.loader.PactFolder
import au.com.dius.pact.provider.junit.target.TestTarget
import au.com.dius.pact.provider.spring.target.MockMvcTarget
import com.nhaarman.mockito_kotlin.any
import com.paucls.tasklist.api.TaskController
import com.paucls.tasklist.application.Task
import com.paucls.tasklist.application.TaskService
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.Mockito.`when` as whenever

@RunWith(RestPactRunner::class)
@Provider("task-list-api")
@PactFolder("pacts")
class TaskListUIPactProviderTest {

    @Mock
    lateinit var taskServiceMock: TaskService

    @InjectMocks
    lateinit var taskController: TaskController

    @JvmField
    @TestTarget
    val target = MockMvcTarget()

    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
        target.setControllers(taskController)
    }

    @State("tasks exists")
    fun `a request to get tasks`() {
        val task = Task(id = "task-id", name = "a name", userId = "user-id", done = true)
        whenever(taskServiceMock.getAll()).thenReturn(listOf(task))
    }

    @State("a task with id task-id does not exist")
    fun `a request to create task task-id`() {
        val task = Task(id = "task-id", name = "a name", userId = "user-id", done = true)
        whenever(taskServiceMock.create(any())).thenReturn(task)
    }

    @State("a task with id task-id exists")
    fun `a request to delete task task-id`() {
    }
}
