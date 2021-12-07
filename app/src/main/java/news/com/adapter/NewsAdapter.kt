package news.com.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import news.com.DetailActivity
import news.com.R
import news.com.data.News

class NewsAdapter(private val listNews: ArrayList<News>) : RecyclerView.Adapter<NewsAdapter.MyViewHolder>(){

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.title_news_rows)
        val tvAuthor : TextView = view.findViewById(R.id.author_row_item)
        val tvTime : TextView = view.findViewById(R.id.time_row_item)
        val imgNews : ImageView = view.findViewById(R.id.img_row_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.row_item_news, parent, false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.apply {
            tvTitle.text = listNews[position].title
            tvAuthor.text = listNews[position].author
            tvTime.text = listNews[position].time
            imgNews.setImageResource(listNews[position].image)

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java)
                intent.putExtra("data", listNews[position])
                itemView.context.startActivity(intent)

            }
        }
    }

    override fun getItemCount() = 2


}