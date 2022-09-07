package com.example.navigationpractice.Database

import androidx.room.*
import com.example.navigationpractice.Model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface MyDao {
    @Query("SELECT * FROM Notes")
    fun getAll(): Flow<List<Note>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)

    @Delete
    suspend fun delete(note: Note)
}