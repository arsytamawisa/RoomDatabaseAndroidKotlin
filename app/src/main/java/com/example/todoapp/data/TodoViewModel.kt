package com.example.todoapp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class TodoViewModel(application: Application): AndroidViewModel(application) {
    private val repository : TodoRepository
    private val todoDao : TodoDao
    private var job = Job()
    private val uiScope = CoroutineScope(Dispatchers.IO + job)

    private var _todos : LiveData<List<Todo>>
    val todos : LiveData<List<Todo>>
        get() = _todos

    init {
        todoDao = TodoDatabase.getInstance(application).todoDao()
        repository = TodoRepository(todoDao)
        _todos = repository.findAll
    }

    fun addTodo(text: String) {
        uiScope.launch {
            repository.insert(Todo(0, text))
        }
    }

    fun removeTodo(todo: Todo) {
        uiScope.launch {
            repository.delete(todo)
        }
    }

    fun updateTodo(pos: Int, text: String) {

    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}