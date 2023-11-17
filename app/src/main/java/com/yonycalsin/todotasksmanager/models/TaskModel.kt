package com.yonycalsin.todotasksmanager.models

data class TaskModel(
    val name: String,
    val category: TaskCategory,
    var isSelected: Boolean = false
)