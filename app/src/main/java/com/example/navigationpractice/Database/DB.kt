package com.example.navigationpractice.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.navigationpractice.Model.Note

@Database(entities = [Note::class], version = 1)
abstract class DB : RoomDatabase(){
    abstract fun noteDao() : MyDao

    companion object{
        @Volatile
        private var INSTANCE: DB? = null

        fun getDatabase(context: Context): DB{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DB::class.java,
                    "notes_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}