package newmvvm.feature.newsapi.data.model.mapper

import newmvvm.common.core.BaseMapper
import newmvvm.feature.newsapi.data.model.ArticleModel
import newmvvm.feature.newsapi.domain.model.Article
import newmvvm.feature.newsapi.domain.model.Source
import java.util.*

class ArticleMapper : BaseMapper<ArticleModel, Article> {
    override fun mapToDomain(model: ArticleModel): Article {
        return Article(
                source = Source(id = 0, name = ""),
                url = model.url,
                author = model.author ?: "",
                content = model.content ?: "",
                description = model.description ?: "",
                publishedAt = Date(),
                title = model.title ?: "",
                urlToImage = model.urlToImage ?: ""
        )
    }

    override fun mapToModel(domain: Article): ArticleModel {
        return ArticleModel(
                url = domain.url,
                author = domain.author,
                content = domain.content,
                description = domain.description,
                publishedAt = Date(),
                title = domain.title,
                urlToImage = domain.urlToImage
        )
    }

}