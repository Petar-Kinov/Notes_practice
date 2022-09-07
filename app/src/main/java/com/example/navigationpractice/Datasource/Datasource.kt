package com.example.navigationpractice.Datasource

import com.example.navigationpractice.Model.Note

class Datasource {
    fun loadNotes(): List<Note>{
        return listOf(
            Note(1,"Note 1"),
            Note(2,"Note 2"),
            Note(3,"Note 3")
        )
    }
}