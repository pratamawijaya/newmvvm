package newmvvm.feature.newsapi.data.local

import androidx.room.Dao
import androidx.room.Insert
import newmvvm.feature.newsapi.data.local.entity.ArticleEntity

@Dao
interface ArticleDao {
    @Insert
    fun insert(article: ArticleEntity)
}