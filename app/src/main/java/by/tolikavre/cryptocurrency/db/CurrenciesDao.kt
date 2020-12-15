package by.tolikavre.cryptocurrency.db

import androidx.lifecycle.LiveData
import androidx.room.*
import by.tolikavre.cryptocurrency.db.unitlocolized.UnitCurrenciesEntryImpl
import by.tolikavre.cryptocurrency.model.latest.ResultEntry

@Dao
interface CurrenciesDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(resultEntry: List<ResultEntry>)

  @Query("select * from currencies_db")
  fun getListCurrencies(): LiveData<List<UnitCurrenciesEntryImpl>>
}