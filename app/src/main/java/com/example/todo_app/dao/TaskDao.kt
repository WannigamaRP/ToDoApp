package com.example.todo_app.dao

import android.adservices.adid.AdId
import android.icu.text.CaseMap.Title
import android.service.autofill.CustomDescription
import androidx.room.*
import com.example.todo_app.models.Task
import kotlinx.coroutines.flow.Flow


@Dao
interface TaskDao {

    @Query("SELECT * FROM Task ORDER BY date DESC")
    fun getTaskList() : Flow<List<Task>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task): Long

    //First way
    @Delete
    suspend fun deleteTask(task: Task) : Int

    //Second way
    @Query("DELETE FROM Task WHERE taskId == :taskId")
    suspend fun deleteTaskUsingId(taskId: String) : Int

    @Update
    suspend fun updateTask(task: Task): Int

    @Query("UPDATE Task SET taskTitle = :title, description = :description WHERE taskId = :taskId")
    suspend fun updateTaskParticularField(taskId: String,title: String,description: String): Int

 }