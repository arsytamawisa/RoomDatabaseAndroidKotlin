package com.example.todoapp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TodoViewModel: ViewModel() {

//    private val repository : TodoRepository
//    private val todoDao : TodoDao
    private val _todos = MutableLiveData<ArrayList<Todo>>()
    val todos : LiveData<ArrayList<Todo>>
        get() = _todos

    init {
        _todos.value = arrayListOf(
            Todo(1,"mandi"),
            Todo(2,"ngoding")
        )
//        todoDao = TodoDatabase
//            .getInstance(application).todoDao()
    }

    fun addTodo(text: String) {
        val newId = _todos.value!!.size + 1
        _todos.value!!.add(Todo(newId, text))
        _todos.postValue(_todos.value)
    }

    fun removeTodo(pos: Int) {
        _todos.value!!.removeAt(pos)
        _todos.postValue(_todos.value)
    }

    fun updateTodo(pos: Int, text: String) {
        _todos.value!![pos].task = text
        _todos.postValue(_todos.value)
    }
}