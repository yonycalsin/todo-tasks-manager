package com.yonycalsin.todotasksmanager

import android.annotation.SuppressLint
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
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
        TaskModel("Second Task", TaskCategory.Personal, false),
        TaskModel("Third Task", TaskCategory.Other, false),
    )

    private lateinit var recyclerViewCategories: RecyclerView

    private lateinit var categoriesRecyclerViewAdapter: CategoriesRecyclerViewAdapter

    private lateinit var recyclerViewTasks: RecyclerView

    private lateinit var tasksRecyclerViewAdapter: TasksRecyclerViewAdapter

    private lateinit var floatingActionButtonAddTask: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        initComponents()

        initListeners()

        initUI()
    }

    private fun initComponents() {
        recyclerViewCategories = findViewById(R.id.recyclerViewCategories)

        recyclerViewTasks = findViewById(R.id.recyclerViewTasks)

        floatingActionButtonAddTask = findViewById(R.id.floatingActionButtonAddTask)
    }

    private fun initListeners() {
        floatingActionButtonAddTask.setOnClickListener { showDialogAddTask() }
    }

    private fun initUI() {
        categoriesRecyclerViewAdapter =
            CategoriesRecyclerViewAdapter(categories) { handleOnCategorySelected(it) }

        recyclerViewCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        recyclerViewCategories.adapter = categoriesRecyclerViewAdapter

        tasksRecyclerViewAdapter = TasksRecyclerViewAdapter(tasks) { handleOnTaskSelected(it) }

        recyclerViewTasks.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recyclerViewTasks.adapter = tasksRecyclerViewAdapter
    }

    private fun handleOnTaskSelected(position: Int) {
        tasks[position].isSelected = !tasks[position].isSelected

        tasksRecyclerViewAdapter.notifyItemChanged(position)
    }

    private fun handleOnCategorySelected(position: Int) {
        categories[position].isSelected = !categories[position].isSelected

        updateAllTasksRecyclerView()

        categoriesRecyclerViewAdapter.notifyItemChanged(position)
    }

    private fun showDialogAddTask() {
        val dialog = Dialog(this)

        dialog.setContentView(R.layout.dialog_add_task)

        val editTextTaskName: EditText = dialog.findViewById(R.id.editTextTaskName)

        val radioGroupTaskCategories: RadioGroup =
            dialog.findViewById(R.id.radioGroupTaskCategories)

        val buttonAddTask: Button = dialog.findViewById(R.id.buttonAddTask)

        buttonAddTask.setOnClickListener {
            val currentTaskName = editTextTaskName.text.toString()

            if (currentTaskName.isNotEmpty()) {
                val selectedTaskCategoryId = radioGroupTaskCategories.checkedRadioButtonId

                val radioButtonSelectedTaskCategory =
                    radioGroupTaskCategories.findViewById<RadioButton>(selectedTaskCategoryId)

                val selectedTaskCategory: TaskCategory =
                    when (radioButtonSelectedTaskCategory.text) {
                        "Business" -> TaskCategory.Business
                        "Personal" -> TaskCategory.Personal
                        "Other" -> TaskCategory.Other
                        else -> TaskCategory.Other
                    }

                tasks.add(TaskModel(editTextTaskName.text.toString(), selectedTaskCategory))

                updateAllTasksRecyclerView()

                dialog.hide()
            }
        }

        dialog.show()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun updateAllTasksRecyclerView() {
        val selectedCategories = categories.filter { it.isSelected }

        val newTasks = tasks.filter { selectedCategories.contains(it.category) }

        tasksRecyclerViewAdapter.tasks = newTasks

        tasksRecyclerViewAdapter.notifyDataSetChanged()
    }
}