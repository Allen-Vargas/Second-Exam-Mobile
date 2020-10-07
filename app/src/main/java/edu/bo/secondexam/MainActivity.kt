package edu.bo.secondexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row_book.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            val bookDao = AppRoomDatabase.getDatabase(applicationContext).bookDato()
            val repository = BookRepository(bookDao)
            //repository.insert(Book("Harry Potter y la piedra Filosofal", "500", "Angeles","J.K Rowling","Fantasy","https://img1.od-cdn.com/ImageType-400/3450-1/633/251/A3/%7B633251A3-C8FD-4FB3-A190-95E07EA18B30%7DImg400.jpg"))
            //repository.insert(Book("Señor de los Anillos comunidad del anillo", "253", "Angeles","J.R.R Tolkien","Fantasy-War","https://i.pinimg.com/originals/b6/db/ae/b6dbae3874432454e503ebae0e841c4f.jpg"))

            val lista = repository.getListBooks()
            val bookListAdapter = BookListAdapter(lista as ArrayList<Book>, applicationContext)
            recyclerView.adapter = bookListAdapter

            val linearLayoutManager = LinearLayoutManager(applicationContext)
            linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
            recyclerView.layoutManager = linearLayoutManager
        }

        btnAddFloating.setOnClickListener{
            startActivity(Intent(this,AddBookActivity::class.java))
        }
    }
}