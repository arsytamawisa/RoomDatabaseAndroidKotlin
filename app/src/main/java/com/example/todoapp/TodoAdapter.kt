package com.example.todoapp

import android.app.AlertDialog
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.data.TodoViewModel
import com.example.todoapp.databinding.ActivityMainBinding
import com.example.todoapp.databinding.ListItemBinding

class TodoAdapter(private val viewModel: TodoViewModel) :
    RecyclerView.Adapter<TodoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.todoText.text = viewModel.todos.value!![position].task

        viewHolder.delBtn.setOnClickListener {
            viewModel.todos.value!!.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, viewModel.todos.value!!.size)
        }

        viewHolder.editBtn.setOnClickListener {
            val context = viewHolder.itemView.context
            val inflater = LayoutInflater.from(context)
            val view = inflater.inflate(R.layout.edit_item, null)

            val prevText = viewModel.todos.value!![position].task
            val editText = view.findViewById<TextView>(R.id.editTextItem)
            editText.text = prevText


            /* Dialog */
            var alertDialog = AlertDialog.Builder(context)
            alertDialog.setTitle("Edit Item")
                .setView(view)
                .setPositiveButton("Update", DialogInterface.OnClickListener { dialog, id ->
                    viewModel.todos.value!![position].task = editText.text.toString()
                    notifyDataSetChanged()
                })
                .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->

                })
            alertDialog.show()
        }
    }

    override fun getItemCount() = viewModel.todos.value!!.size

    class ViewHolder(binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val todoText = binding.textViewItem
        val delBtn = binding.btnDelete
        val editBtn = binding.btnEdit
    }
}