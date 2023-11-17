package com.yonycalsin.todotasksmanager.viewholders

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.yonycalsin.todotasksmanager.R
import com.yonycalsin.todotasksmanager.models.TaskCategory

class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val cardViewTaskCategory: CardView = view.findViewById(R.id.cardViewTaskCategory)

    private val textViewCategoryName: TextView = view.findViewById(R.id.textViewCategoryName)

    private val viewDivider: View = view.findViewById(R.id.viewDivider)

    fun render(taskCategory: TaskCategory, handleOnCategorySelected: (Int) -> Unit) {
        itemView.setOnClickListener { handleOnCategorySelected(layoutPosition) }

        val color = if (taskCategory.isSelected) {
            R.color.primary_200
        } else {
            R.color.primary_100
        }

        cardViewTaskCategory.setCardBackgroundColor(
            ContextCompat.getColor(
                cardViewTaskCategory.context,
                color
            )
        )

        when (taskCategory) {
            TaskCategory.Personal -> {
                textViewCategoryName.text = "Personal"

                viewDivider.setBackgroundColor(
                    ContextCompat.getColor(
                        viewDivider.context,
                        R.color.primary_500
                    )
                )
            }

            TaskCategory.Business -> {
                textViewCategoryName.text = "Business"

                viewDivider.setBackgroundColor(
                    ContextCompat.getColor(
                        viewDivider.context,
                        R.color.secondary_500
                    )
                )
            }

            TaskCategory.Other -> {
                textViewCategoryName.text = "Other"

                viewDivider.setBackgroundColor(
                    ContextCompat.getColor(
                        viewDivider.context,
                        R.color.success_500
                    )
                )
            }
        }
    }

}