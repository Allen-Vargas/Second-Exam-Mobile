package edu.bo.secondexam

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_book.view.*

class BookListAdapter(val items: ArrayList<Book>, val context: Context): RecyclerView.Adapter<BookListAdapter.BookListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_book, parent, false)
        return BookListViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: BookListViewHolder, position: Int) {
        val book = items.get(position)
        holder.itemView.txtTittle.text = book.title
        holder.itemView.txtPages.text = book.pages
        holder.itemView.txtEditorial.text = book.editorial
        holder.itemView.txtAuthor.text = book.author
        holder.itemView.txtDescription.text = book.description
        holder.itemView.txtPhotoURL.text = book.photoURL
    }

    class BookListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}