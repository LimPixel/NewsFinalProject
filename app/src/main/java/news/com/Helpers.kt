package news.com

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import news.com.data.DataNews
import java.text.FieldPosition

fun initViewHeadline(context: Context, view : View, position: Int){
    val tvTitleImg = view.findViewById<TextView>(R.id.title_img)
    val imgLastUpdate = view.findViewById<ImageView>(R.id.image_last_update)


    imgLastUpdate.setImageResource(DataNews.photoHeadline[position])
    tvTitleImg.text = DataNews.titleHeadline[position]

    view.setOnClickListener{
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("title", DataNews.titleHeadline[position])
        intent.putExtra("content", DataNews.contentHeadline[position])
        intent.putExtra("image", DataNews.photoHeadline[position])
        context.startActivity(intent)


    }
}