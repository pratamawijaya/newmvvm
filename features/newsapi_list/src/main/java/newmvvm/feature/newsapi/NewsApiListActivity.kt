package newmvvm.feature.newsapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_news_api_list.*
import newmvvm.feature.newsapi.di.injectFeature
import newsapi.feature.newsapilist.R

class NewsApiListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_api_list)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "NewsAPI"

        injectFeature()
    }
}
