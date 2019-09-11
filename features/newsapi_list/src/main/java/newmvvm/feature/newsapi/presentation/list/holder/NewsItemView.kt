package newmvvm.feature.newsapi.presentation.list.holder

import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_news.view.*
import newmvvm.common.extensions.loadFromUrl
import newmvvm.feature.newsapi.domain.model.Article
import newsapi.feature.newsapilist.R

interface NewsItemListener {
    fun onNewsClick(article: Article)
}

class NewsItemView(
    val article: Article,
    private val listener: NewsItemListener
) : Item() {

    override fun bind(viewHolder: ViewHolder, position: Int) {
        val tvTitle = viewHolder.itemView.tvNewsTitle
        val imgNews = viewHolder.itemView.imgNews

        tvTitle.text = article.title
        imgNews.loadFromUrl(article.urlToImage)

        viewHolder.itemView.setOnClickListener {
            listener.onNewsClick(article)
        }
    }

    override fun getLayout(): Int = R.layout.item_news
}