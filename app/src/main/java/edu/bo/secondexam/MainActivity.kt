package edu.bo.secondexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val picasso = Picasso.get()
        //picasso.load("https://i.pinimg.com/564x/a8/6e/26/a86e26dffbcd0f8ffd0b7a6a4809ec68.jpg").into(my_image_view)


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

        btnAddFloating.setOnClickListener{
            startActivity(Intent(this,AddBookActivity::class.java))
        }
    }
}