package by.tolikavre.cryptocurrency.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import by.tolikavre.cryptocurrency.network.response.CurrenciesResponse
import java.io.IOException

class CurrenciesNetworkDataSourceImpl(
  private val networkService: NetworkService
) : CurrenciesNetworkDataSource {

  private val _downloadCurrencies = MutableLiveData<CurrenciesResponse>()

  override val downloadCurrencies: LiveData<CurrenciesResponse>
    get() = _downloadCurrencies

  override suspend fun fetchCurrencies() {
    try {
      val fetchedCurrencies = networkService
        .getListCurrencies()
        .await()
      _downloadCurrencies.postValue(fetchedCurrencies)
    } catch (e: IOException) {
      Log.e("Connectivity", "No internet connection.", e)
    }
  }
}