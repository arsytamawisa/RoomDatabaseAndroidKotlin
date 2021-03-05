package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var viewAdapter: RecyclerView.Adapter<*>
    lateinit var viewManager: RecyclerView.LayoutManager
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val todos = mutableListOf(
            "todo 1", "todo 2"
        )

        binding.apply {
            btnNew.setOnClickListener {
                todos.add(editTextAdd.text.toString())
                editTextAdd.text.clear()
            }
        }


        viewManager = LinearLayoutManager(this)
        viewAdapter = TodoAdapter(todos)

        binding.myRecyclerView.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}