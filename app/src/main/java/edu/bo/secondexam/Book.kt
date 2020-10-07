package edu.bo.secondexam

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book_table")
class Book(
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "pages") var pages: String,
    @ColumnInfo(name = "editorial") var editorial: String,
    @ColumnInfo(name = "author") var author: String,
    @ColumnInfo(name = "description" ) var description: String,
    @ColumnInfo(name = "photoURL") var photoURL: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0
}