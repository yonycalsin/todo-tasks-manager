package com.yonycalsin.todotasksmanager.viewholders

import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.yonycalsin.todotasksmanager.R
import com.yonycalsin.todotasksmanager.models.TaskCategory
import com.yonycalsin.todotasksmanager.models.TaskModel

class TasksRecyclerViewViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val checkboxTaskStatus = view.findViewById<CheckBox>(R.id.checkboxTaskStatus)

    private val textViewTaskName = view.findViewById<TextView>(R.id.textViewTaskName)

    fun render(task: TaskModel) {
        textViewTaskName.text = task.name

        if (task.isSelected) {
            textViewTaskName.paintFlags = textViewTaskName.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            textViewTaskName.paintFlags =
                textViewTaskName.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }

        val color = when (task.category) {
            TaskCategory.Personal -> R.color.primary_500
            TaskCategory.Business -> R.color.secondary_500
            TaskCategory.Other -> R.color.success_500

        }

        checkboxTaskStatus.buttonTintList =
            ColorStateList.valueOf(ContextCompat.getColor(checkboxTaskStatus.context, color))

        checkboxTaskStatus.isChecked = task.isSelected
    }

}