package com.yonycalsin.todotasksmanager.viewholders

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yonycalsin.todotasksmanager.R
import com.yonycalsin.todotasksmanager.models.TaskModel

class TasksRecyclerViewViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val checkboxTaskStatus = view.findViewById<CheckBox>(R.id.checkboxTaskStatus)

    private val textViewTaskName = view.findViewById<TextView>(R.id.textViewTaskName)

    fun render(task: TaskModel) {
        textViewTaskName.text = task.name
    }

}