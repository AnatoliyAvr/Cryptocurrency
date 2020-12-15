package by.tolikavre.cryptocurrency.db.unitlocolized

import androidx.room.ColumnInfo
import androidx.room.Embedded
import by.tolikavre.cryptocurrency.model.latest.Quote

data class UnitCurrenciesEntryImpl(
  @ColumnInfo(name = "name")
  override val name: String,
  @ColumnInfo(name = "id")
  override val id: Int,
  @Embedded
  override val quote: Quote,
) : UnitCurrenciesEntry