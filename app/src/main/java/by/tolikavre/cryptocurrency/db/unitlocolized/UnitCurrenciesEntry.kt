package by.tolikavre.cryptocurrency.db.unitlocolized

import by.tolikavre.cryptocurrency.model.latest.Quote

interface UnitCurrenciesEntry {
  val name: String
  val id: Int
  val quote: Quote
}