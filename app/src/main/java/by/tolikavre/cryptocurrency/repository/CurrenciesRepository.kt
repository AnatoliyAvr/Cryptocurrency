package by.tolikavre.cryptocurrency.repository

import androidx.lifecycle.LiveData
import by.tolikavre.cryptocurrency.db.unitlocolized.UnitCurrenciesEntry

interface CurrenciesRepository {
  suspend fun getCryptocurrency(): LiveData<out List<UnitCurrenciesEntry>>
}