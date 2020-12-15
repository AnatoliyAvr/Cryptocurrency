package by.tolikavre.cryptocurrency.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import by.tolikavre.cryptocurrency.model.latest.ResultEntry

@Database(
  entities = [ResultEntry::class],
  version = 1
)
abstract class CurrenciesDatabase : RoomDatabase() {

  abstract fun currenciesDao(): CurrenciesDao

  companion object {
    @Volatile
    private var instance: CurrenciesDatabase? = null
    private val LOCK = Any()

    operator fun invoke(context: Context) = instance
      ?: synchronized(LOCK) {
        instance
          ?: buildDatabase(context).also { instance = it }
      }

    private fun buildDatabase(context: Context) =
      Room.databaseBuilder(
        context.applicationContext,
        CurrenciesDatabase::class.java, "currencies.db"
      ).build()
  }
}