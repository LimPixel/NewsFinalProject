package news.com

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import news.com.data.News

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA_TITLE = "title"
        const val EXTRA_DATA_TIME = "time"
        const val EXTRA_DATA_AUTHOR = "author"
        const val EXTRA_DATA_CONTENT = "content"
        const val EXTRA_DATA_IMAGE = "image"
        const val EXTRA_DATA_OBJECT = "news"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(findViewById(R.id.toolbar_detail))
        supportActionBar?.apply {
            setDisplayShowHomeEnabled(true)
            setDisplayHomeAsUpEnabled(true)
            title = "Detail"
        }


        val tvTitleDetail = findViewById<TextView>(R.id.title_detail)
        tvTitleDetail.text = intent.getStringExtra("title")

        val tvAuthorDetail = findViewById<TextView>(R.id.author_detail)
        tvAuthorDetail.text = intent.getStringExtra("author")

        val tvTimeDetail = findViewById<TextView>(R.id.time_detail)
        tvTimeDetail.text = intent.getStringExtra("time")

        val tvContentDetail = findViewById<TextView>(R.id.content_detail)
        tvContentDetail.text = intent.getStringExtra("content")

        val imgDetail = findViewById<ImageView>(R.id.img_detail)
        imgDetail.setImageResource(intent.getIntExtra("image", 0))


        val dataNews = intent.getParcelableExtra<News>(EXTRA_DATA_OBJECT)
        tvTitleDetail.text = dataNews?.title
        tvAuthorDetail.text = dataNews?.author
        tvTimeDetail.text = dataNews?.time
        tvContentDetail.text =dataNews?.content
        dataNews?.let { imgDetail.setImageResource(it.image) }



    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}