package newmvvm.feature.newsapi.data.model

import java.util.*

data class ArticleModel(val author: String? = "",
                        val url: String,
                        val content: String? = "",
                        val description: String? = "",
                        val title: String? = "",
                        val urlToImage: String? = "",
                        val publishedAt: Date
)

