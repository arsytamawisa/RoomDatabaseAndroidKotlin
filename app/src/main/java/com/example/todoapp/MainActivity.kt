package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.data.Todo
import com.example.todoapp.data.TodoViewModel
import com.example.todoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewAdapter: TodoAdapter
    private lateinit var viewModel: TodoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProviders.of(this).get(TodoViewModel::class.java)

        viewManager = LinearLayoutManager(this)
        viewAdapter = TodoAdapter(viewModel)
        recyclerView = binding.myRecyclerView

        recyclerView.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

        binding.apply {
            btnNew.setOnClickListener {
                viewModel.addTodo(editTextAdd.text.toString())
                editTextAdd.text.clear()
            }
        }

        viewModel.todos.observe(this, Observer {
            viewAdapter.submitList(it.toMutableList())
        })
    }
}