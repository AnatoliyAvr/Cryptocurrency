package by.tolikavre.cryptocurrency.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import by.tolikavre.cryptocurrency.repository.CurrenciesRepository

class ListCurrenciesViewModelFactory(
  private val currenciesRepository: CurrenciesRepository
) : ViewModelProvider.NewInstanceFactory() {

  override fun <T : ViewModel?> create(modelClass: Class<T>): T {
    return ListCurrenciesViewModel(currenciesRepository) as T
  }
}