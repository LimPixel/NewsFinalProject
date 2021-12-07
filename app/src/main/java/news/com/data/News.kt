package news.com.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class News(
    val title: String,
    val content: String,
    val author: String,
    val time: String,
    val image: Int,
):Parcelable
