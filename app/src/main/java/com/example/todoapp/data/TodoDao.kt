package com.example.todoapp.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TodoDao {

    @Query("SELECT * FROM todo")
    fun loadTodo() : LiveData<List<Todo>>

    @Insert
    fun insertDao(todo: Todo)

    @Update
    fun updateDao(todo: Todo)

    @Delete
    fun deleteDao(todo: Todo)
}