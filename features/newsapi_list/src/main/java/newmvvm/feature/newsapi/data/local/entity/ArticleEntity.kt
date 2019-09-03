package newmvvm.feature.newsapi.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import newmvvm.feature.newsapi.data.remote.model.ArticleModel
import java.util.*

@Entity(tableName = "article")
data class ArticleEntity(
        val title: String,
        val author: String,
        @PrimaryKey
        val url: String,
        val content: String,
        val description: String,
        val urlToImage: String,
        val publishedAt: String
)

fun ArticleEntity.toArticleModel(): ArticleModel {
    return ArticleModel(
            author = this.author,
            title = this.title,
            url = this.url,
            content = this.content,
            description = this.description,
            urlToImage = this.urlToImage,
            publishedAt = Date()
    )
}