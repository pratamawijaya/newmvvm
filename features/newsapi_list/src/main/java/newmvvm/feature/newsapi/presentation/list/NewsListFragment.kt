package newmvvm.feature.newsapi.presentation.list


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.github.ajalt.timberkt.d
import com.github.ajalt.timberkt.e
import newsapi.feature.newsapilist.R
import org.koin.android.ext.android.inject

/**
 * A simple [Fragment] subclass.
 */
class NewsListFragment : Fragment() {

    private val vm: NewsListViewModel by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.topHeadlines()
        vm.newsListState.observe(this, stateObserver)
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
                }
            }
        }
    }

}
