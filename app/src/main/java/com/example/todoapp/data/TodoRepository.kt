package com.example.todoapp.data

class TodoRepository(private val TodoDao: TodoDao) {
    val findAll = TodoDao.loadTodo()

    suspend fun insert(todo: Todo) {
        TodoDao.insertDao(todo)
    }

    suspend fun delete(todo: Todo) {
        TodoDao.deleteDao(todo)
    }

    suspend fun add(todo: Todo) {
        TodoDao.updateDao(todo)
    }
}