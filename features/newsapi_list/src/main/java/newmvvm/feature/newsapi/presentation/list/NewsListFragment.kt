package newmvvm.feature.newsapi.presentation.list


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_news_list.*

import newsapi.feature.newsapilist.R

/**
 * A simple [Fragment] subclass.
 */
class NewsListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnDetail.setOnClickListener {
            it.findNavController().navigate(R.id.action_fragment_news_list_to_newsDetailFragment)
        }
    }

}
