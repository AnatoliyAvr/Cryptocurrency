package by.tolikavre.cryptocurrency.model.latest

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currencies_db")
data class ResultEntry(
  @PrimaryKey(autoGenerate = true)
  val id: Int,
  val name: String,
  @Embedded
  val quote: Quote,
)