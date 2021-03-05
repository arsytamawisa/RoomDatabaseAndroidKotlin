package com.example.todoapp.data

import android.content.Context

//@Database(version = 1, entities = [Todo::class])
//abstract class TodoDatabase : RoomDatabase() {
//
//    abstract fun todoDao() : TodoDao
//
//
//    companion object {
//        @Volatile
//        private var INSTANCE: TodoDatabase? = null
//
//        fun getInstance(context: Context) : TodoDatabase {
//            synchronized(this) {
//                var instance = INSTANCE
//
//                if (instance == null) {
//                    instance = Room.databaseBuilder(
//                        context.applicationContext,
//                        TodoDatabase::class.java,
//                        "todo_database"
//                    ).fallbackToDestructiveMigration().build()
//                    INSTANCE = instance
//                }
//                return instance
//            }
//        }
//    }
//}