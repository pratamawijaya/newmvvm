package newmvvm.feature.newsapi.data.model

import newmvvm.feature.newsapi.domain.model.Article
import newmvvm.feature.newsapi.domain.model.Source
import java.util.*

data class ArticleModel(val author: String,
                        val url: String,
                        val content: String,
                        val description: String,
                        val title: String,
                        val urlToImage: String
) {
    fun toArticleDomain() = Article(
            source = Source(id = 0, name = ""),
            url = this.url,
            author = this.author,
            content = this.content,
            description = this.description,
            publishedAt = Date(),
            title = this.title,
            urlToImage = this.urlToImage
    )
}

