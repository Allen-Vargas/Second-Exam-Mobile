package edu.bo.secondexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            val bookDao = AppRoomDatabase.getDatabase(applicationContext).bookDato()
            val repository = BookRepository(bookDao)
            //repository.insert(Book("Harry Potter y la piedra Filosofal", "500", "Angeles","J.K Rowling","Fantasy","Google.com"))

            val lista = repository.getListBooks()
            val bookListAdapter = BookListAdapter(lista as ArrayList<Book>, applicationContext)
            recyclerView.adapter = bookListAdapter

            val linearLayoutManager = LinearLayoutManager(applicationContext)
            linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
            recyclerView.layoutManager = linearLayoutManager
        }
    }
}