package by.tolikavre.cryptocurrency.ui.list

import androidx.lifecycle.ViewModel
import by.tolikavre.cryptocurrency.internal.lazyDeferred
import by.tolikavre.cryptocurrency.repository.CurrenciesRepository

class ListCurrenciesViewModel(
  private val currenciesRepository: CurrenciesRepository
) : ViewModel() {

  val currencies by lazyDeferred {
    currenciesRepository.getCryptocurrency()
  }
}
