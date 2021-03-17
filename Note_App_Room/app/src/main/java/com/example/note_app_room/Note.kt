package com.example.note_app_room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * A basic class representing an entity that is a row in a one-column database table.
 *
 * @ Entity - You must annotate the class as an entity and supply a table name if not class name.
 * @ PrimaryKey - You must identify the primary key.
 * @ ColumnInfo - You must supply the column name if it is different from the variable name.
 *
 * See the documentation for the full rich set of annotations.
 * https://developer.android.com/topic/libraries/architecture/room.html
 */

@Entity(tableName = "note_table")                         // Inside Entity we have created note name
class Note (@ColumnInfo (name="text")val text: String){   // @ColumnInfo for declare name of the column (we can use or ignore)
    @PrimaryKey(autoGenerate = true)var id=0              // @PrimaryKey for this is using in primary and we can use this line inside primary constructor
}