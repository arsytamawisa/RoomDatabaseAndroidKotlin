//package com.example.todoapp.data
//
//import android.app.Application
//import androidx.lifecycle.AndroidViewModel
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.ViewModel
//
//class TodoViewModel(application: Application) : AndroidViewModel(application) {
//
//    private val repository : TodoRepository
//
//    private val todoDao : TodoDao
//
//    private _todos = MutableLiveData<ArrayList<Todo>>()
//
//    val todos : LiveData<ArrayList<Todo>>
//        get() = _todos
//
//    init {
//        todoDao = TodoDatabase
//            .getInstance(application).todoDao()
//    }
//
//    fun addTodo(text: String) {
//        val newId = todos.value!!.size + 1
//        _todos.value!!.removeAt(pos)
//
//    }
//}