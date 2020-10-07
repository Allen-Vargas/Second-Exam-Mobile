package edu.bo.secondexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_add_book.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddBookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_book)

        btnAddNewBook.setOnClickListener{
            GlobalScope.launch {
                val bookDao = AppRoomDatabase.getDatabase(applicationContext).bookDato()
                val repository = BookRepository(bookDao)

                repository.insert(Book(EditTxtTitle.text.toString(),
                                      EditTxtPages.text.toString(),
                                      EditTxtEditorial.text.toString(),
                                      EditTxtAuthor.text.toString(),
                                      EditTxtDescription.text.toString(),
                                      EditTxtPhotURL.text.toString()))
            }
            startActivity(Intent(this, MainActivity::class.java))
        }

        btnFlotCanceled.setOnClickListener{
            val myIntent = Intent(applicationContext, MainActivity::class.java)
            startActivityForResult(myIntent, 0)
        }
    }
}