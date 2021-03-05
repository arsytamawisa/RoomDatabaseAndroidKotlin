package com.example.todoapp

import android.app.AlertDialog
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(private val dataSet: MutableList<String>) :
    RecyclerView.Adapter<TodoAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val todoText = itemView.findViewById<TextView>(R.id.textViewItem)
        val delBtn = itemView.findViewById<Button>(R.id.btnDelete)
        val editBtn = itemView.findViewById<Button>(R.id.btnEdit)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.todoText.text = dataSet[position]

        viewHolder.delBtn.setOnClickListener {
            dataSet.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, dataSet.size)
        }

        viewHolder.editBtn.setOnClickListener {
            val context = viewHolder.itemView.context
            val inflater = LayoutInflater.from(context)
            val view = inflater.inflate(R.layout.edit_item, null)

            val prevText = dataSet[position]
            val editText = view.findViewById<TextView>(R.id.editTextItem)
            editText.text = prevText

            // dialog
            var alertDialog = AlertDialog.Builder(context)
            alertDialog.setTitle("Edit Item")
                .setView(view)
                .setPositiveButton("Update", DialogInterface.OnClickListener { dialog, id ->
                    dataSet[position] = editText.text.toString()
                    notifyDataSetChanged()
                })
                .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->

                })
            
            alertDialog.show()
        }
    }

    override fun getItemCount() = dataSet.size
}