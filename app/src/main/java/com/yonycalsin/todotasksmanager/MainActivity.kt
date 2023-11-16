package com.yonycalsin.todotasksmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yonycalsin.todotasksmanager.adapters.CategoriesAdapter
import com.yonycalsin.todotasksmanager.models.TaskCategory

class MainActivity : AppCompatActivity() {

    private val categories = listOf<TaskCategory>(
        TaskCategory.Business,
        TaskCategory.Personal,
        TaskCategory.Other,
    )

    private lateinit var recyclerViewCategories: RecyclerView

    private lateinit var categoriesAdapter: CategoriesAdapter

    private lateinit var recyclerViewTasks: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        this.initComponents()

        this.initUI()
    }

    private fun initComponents() {
        recyclerViewCategories = findViewById(R.id.recyclerViewCategories)

        recyclerViewTasks = findViewById(R.id.recyclerViewTasks)
    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories)

        recyclerViewCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        recyclerViewCategories.adapter = categoriesAdapter
    }
}