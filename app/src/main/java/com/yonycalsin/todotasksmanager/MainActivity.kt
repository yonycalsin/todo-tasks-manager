package com.yonycalsin.todotasksmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yonycalsin.todotasksmanager.adapters.CategoriesRecyclerViewAdapter
import com.yonycalsin.todotasksmanager.adapters.TasksRecyclerViewAdapter
import com.yonycalsin.todotasksmanager.models.TaskCategory
import com.yonycalsin.todotasksmanager.models.TaskModel

class MainActivity : AppCompatActivity() {

    private val categories = listOf<TaskCategory>(
        TaskCategory.Business,
        TaskCategory.Personal,
        TaskCategory.Other,
    )

    private val tasks = mutableListOf<TaskModel>(
        TaskModel("First Task", TaskCategory.Business, false),
        TaskModel("Second Task", TaskCategory.Personal, true),
        TaskModel("Third Task", TaskCategory.Other, false)
    )

    private lateinit var recyclerViewCategories: RecyclerView

    private lateinit var categoriesRecyclerViewAdapter: CategoriesRecyclerViewAdapter

    private lateinit var recyclerViewTasks: RecyclerView

    private lateinit var tasksRecyclerViewAdapter: TasksRecyclerViewAdapter

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
        categoriesRecyclerViewAdapter = CategoriesRecyclerViewAdapter(categories)

        recyclerViewCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        recyclerViewCategories.adapter = categoriesRecyclerViewAdapter

        tasksRecyclerViewAdapter = TasksRecyclerViewAdapter(tasks)

        recyclerViewTasks.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recyclerViewTasks.adapter = tasksRecyclerViewAdapter
    }
}