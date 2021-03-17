package com.example.note_app_room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)  // @Insert means we are inserting colom or inside bracket means we can ignore or replace same things
    suspend fun insert(note: Note)

    // suspend is a coroutine, if we run in these function in main thread then it will
    // freezed so we declare suspend function, with the help of suspend function we can run these function in background thread


    @Delete                                         // @Delete for deletion
    suspend fun delete(note: Note)

    @Query("Select * from note_table order by id ASC" )   // @Query for all things inside recycler view
    fun getAllNotes():  LiveData<List<Note>>

    // LiveData is a observer(lifecycle aware), it is observe lifecycle like if we delete or update then it will observe

}