package com.paucls.tasklist.provider

import au.com.dius.pact.provider.junit.PactRunner
import au.com.dius.pact.provider.junit.Provider
import au.com.dius.pact.provider.junit.State
import au.com.dius.pact.provider.junit.loader.PactFolder
import au.com.dius.pact.provider.junit.target.HttpTarget
import au.com.dius.pact.provider.junit.target.TestTarget
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest

@RunWith(PactRunner::class)
@Provider("task-list-api")
@PactFolder("pacts")
@SpringBootTest
class TaskListUIPactProviderTest {

    @JvmField
    @TestTarget
    final val target: HttpTarget = HttpTarget(8080)

    @State("a task with id task-id exists")
    fun `a task with id task-id exists`() {
    }

    @State("tasks exists")
    fun `tasks exists`() {
    }
}
