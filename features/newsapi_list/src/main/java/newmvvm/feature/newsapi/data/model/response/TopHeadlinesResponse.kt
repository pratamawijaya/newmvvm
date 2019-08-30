package newmvvm.feature.newsapi.data.model.response

import newmvvm.feature.newsapi.data.model.ArticleModel

data class TopHeadlinesResponse(
        val status:String,
        val articles: List<ArticleModel>
)