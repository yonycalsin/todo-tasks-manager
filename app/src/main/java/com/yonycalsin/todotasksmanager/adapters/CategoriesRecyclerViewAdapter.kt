package com.yonycalsin.todotasksmanager.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yonycalsin.todotasksmanager.viewholders.CategoriesViewHolder
import com.yonycalsin.todotasksmanager.R
import com.yonycalsin.todotasksmanager.models.TaskCategory

class CategoriesRecyclerViewAdapter(
    private val categories: List<TaskCategory>,
    private val handleOnCategorySelected: (Int) -> Unit
) :
    RecyclerView.Adapter<CategoriesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_task_category, parent, false)

        return CategoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.render(categories[position], handleOnCategorySelected)
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}