package com.yonycalsin.todotasksmanager.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yonycalsin.todotasksmanager.R
import com.yonycalsin.todotasksmanager.models.TaskModel
import com.yonycalsin.todotasksmanager.viewholders.TasksRecyclerViewViewHolder

class TasksRecyclerViewAdapter(
    private val tasks: List<TaskModel>,
    private val handleOnTaskSelected: (Int) -> Unit
) :
    RecyclerView.Adapter<TasksRecyclerViewViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksRecyclerViewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)

        return TasksRecyclerViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: TasksRecyclerViewViewHolder, position: Int) {
        holder.render(tasks[position])

        holder.itemView.setOnClickListener { handleOnTaskSelected(position) }
    }

    override fun getItemCount(): Int {
        return tasks.size
    }
}