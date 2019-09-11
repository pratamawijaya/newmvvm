package newmvvm.feature.newsapi.data.local.mapper

import newmvvm.common.core.Mapper
import newmvvm.feature.newsapi.data.local.model.ArticleRoomModel
import newmvvm.feature.newsapi.domain.model.Article
import newmvvm.feature.newsapi.domain.model.Source
import java.util.*

class ArticleRoomModelMapper : Mapper<ArticleRoomModel, Article> {
    override fun map(model: ArticleRoomModel): Article {
        return Article(
                source = Source(id = 0, name = ""),
                url = model.url,
                author = model.author,
                content = model.content,
                description = model.description,
                publishedAt = Date(),
                title = model.title,
                urlToImage = model.urlToImage
        )
    }
}