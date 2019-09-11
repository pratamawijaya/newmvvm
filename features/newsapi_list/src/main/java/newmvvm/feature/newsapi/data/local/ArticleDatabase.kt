package newmvvm.feature.newsapi.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import newmvvm.feature.newsapi.data.local.model.ArticleRoomModel

@Database(entities = [ArticleRoomModel::class], version = 1)
abstract class ArticleDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
}