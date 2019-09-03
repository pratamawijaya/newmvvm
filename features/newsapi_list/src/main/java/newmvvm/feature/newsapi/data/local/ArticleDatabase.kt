package newmvvm.feature.newsapi.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import newmvvm.feature.newsapi.data.local.entity.ArticleEntity

@Database(entities = [ArticleEntity::class], version = 1)
abstract class ArticleDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
}