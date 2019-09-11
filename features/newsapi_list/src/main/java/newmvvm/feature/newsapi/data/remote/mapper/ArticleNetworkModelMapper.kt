package newmvvm.feature.newsapi.data.remote.mapper

import newmvvm.common.core.Mapper
import newmvvm.feature.newsapi.data.remote.model.ArticleNetworkModel
import newmvvm.feature.newsapi.domain.model.Article
import newmvvm.feature.newsapi.domain.model.Source
import java.util.*

class ArticleNetworkModelMapper : Mapper<ArticleNetworkModel, Article> {

    override fun map(from: ArticleNetworkModel): Article {
        return Article(
                source = Source(id = 0, name = ""),
                url = from.url,
                author = from.author ?: "",
                content = from.content ?: "",
                description = from.description ?: "",
                publishedAt = Date(),
                title = from.title ?: "",
                urlToImage = from.urlToImage ?: ""
        )
    }
}