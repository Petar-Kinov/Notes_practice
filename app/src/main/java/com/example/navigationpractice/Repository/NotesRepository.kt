package com.example.navigationpractice.Repository

import androidx.annotation.WorkerThread
import com.example.navigationpractice.Database.MyDao
import com.example.navigationpractice.Model.Note
import kotlinx.coroutines.flow.Flow

class NotesRepository(private val notesDao: MyDao) {
    val allNotes: Flow<List<Note>> = notesDao.getAll()

    @WorkerThread
    suspend fun insert(note: Note){
        notesDao.insert(note)
    }
}