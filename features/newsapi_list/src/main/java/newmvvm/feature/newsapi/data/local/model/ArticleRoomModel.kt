package newmvvm.feature.newsapi.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "article")
data class ArticleRoomModel(
    val title: String,
    val author: String,
    @PrimaryKey
    val url: String,
    val content: String,
    val description: String,
    val urlToImage: String,
    val publishedAt: String
)