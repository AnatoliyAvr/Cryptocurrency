package by.tolikavre.cryptocurrency.repository

import androidx.lifecycle.LiveData
import by.tolikavre.cryptocurrency.db.CurrenciesDao
import by.tolikavre.cryptocurrency.db.CurrenciesDatabase
import by.tolikavre.cryptocurrency.db.unitlocolized.UnitCurrenciesEntry
import by.tolikavre.cryptocurrency.network.CurrenciesNetworkDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CurrenciesRepositoryImpl(
  private val currenciesDao: CurrenciesDao,
  private val networkService: CurrenciesNetworkDataSource
) : CurrenciesRepository {

  init {
    networkService.downloadCurrencies.observeForever {
      GlobalScope.launch(Dispatchers.IO) {
        currenciesDao.insert(it.resultEntry)
      }
    }
  }

  override suspend fun getCryptocurrency(): LiveData<out List<UnitCurrenciesEntry>> {
    return withContext(Dispatchers.IO) {
      networkService.fetchCurrencies()
      return@withContext currenciesDao.getListCurrencies()
    }
  }
}