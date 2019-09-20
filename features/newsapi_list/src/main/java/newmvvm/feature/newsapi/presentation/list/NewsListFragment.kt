package newmvvm.feature.newsapi.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.ajalt.timberkt.d
import com.github.ajalt.timberkt.e
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_news_list.*
import newmvvm.feature.newsapi.domain.model.Article
import newmvvm.feature.newsapi.presentation.list.holder.NewsItemListener
import newmvvm.feature.newsapi.presentation.list.holder.NewsItemView
import newsapi.feature.newsapilist.R
import org.koin.android.ext.android.inject

/**
 * A simple [Fragment] subclass.
 */
class NewsListFragment : Fragment(), NewsItemListener {

    private val vm: NewsListViewModel by inject()
    private val newsListAdapter = GroupAdapter<ViewHolder>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // vm.topHeadlines()
        // vm.newsListState.observe(this, stateObserver)

        vm.currentHeadlines.observe(this, Observer { articles ->
            articles.map {
                d { "article -> ${it.title}" }
            }
        })


        rvListNews.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = newsListAdapter
        }
    }

    override fun onNewsClick(article: Article) {
        // todo: implement change screens to detail article
    }

    private val stateObserver = Observer<NewsListState> { state ->
        when (state) {
            is LoadingState -> {
                d { "loading state" }
            }

            is ErrorState -> {
                e { "error state ${state.msg}" }
            }
            is ArticlesLoaded -> {
                state.list.map {
                    d { "Article ${it.title}" }
                    newsListAdapter.add(NewsItemView(it, this))
                }
            }
        }
    }
}
