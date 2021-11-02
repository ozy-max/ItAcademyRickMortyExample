package com.example.itacademyrickmortyexample.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.itacademyrickmortyexample.R
import com.example.itacademyrickmortyexample.models.Result
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class MyAdapter(//read about this
    private val onClick: (Result) -> Unit
) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private val data = mutableListOf<Result>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val item =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(item)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount() = data.size

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(list: List<Result>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()//read about this
    }

    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val icon: CircleImageView = item.findViewById(R.id.circleImageView)
        private val name1TextView: TextView = item.findViewById(R.id.name1TextView)
        private val idTextView: TextView = item.findViewById(R.id.idTextView)




        fun bind(item: Result) {
            Picasso.get().load(item.image).into(icon)
            name1TextView.text = item.name
            idTextView.text = item.id.toString()
            itemView.setOnClickListener { (onClick.invoke(item)) }

        }
    }
}