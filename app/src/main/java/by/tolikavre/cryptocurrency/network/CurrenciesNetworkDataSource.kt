package by.tolikavre.cryptocurrency.network

import androidx.lifecycle.LiveData
import by.tolikavre.cryptocurrency.network.response.CurrenciesResponse

interface CurrenciesNetworkDataSource {
  val downloadCurrencies: LiveData<CurrenciesResponse>
  suspend fun fetchCurrencies()
}