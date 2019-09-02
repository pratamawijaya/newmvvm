package newmvvm.feature.newsapi.presentation.list.holder

import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import newmvvm.feature.newsapi.domain.model.Article
import newmvvm.feature.newsapi.utils.KotlinEpoxyHolder
import newsapi.feature.newsapilist.R
import newsapi.feature.newsapilist.R2

@EpoxyModelClass(layout = R2.layout.item_news)
abstract class NewsItemView : EpoxyModelWithHolder<NewsItemView.Holder>() {

    @EpoxyAttribute
    lateinit var model: Article

    override fun bind(holder: Holder) {
        super.bind(holder)
        holder.newsTitleTv.text = model.title
    }


    inner class Holder : KotlinEpoxyHolder() {
        val newsImg by bind<ImageView>(R.id.imgNews)
        val newsTitleTv by bind<TextView>(R.id.tvNewsTitle)
    }
}