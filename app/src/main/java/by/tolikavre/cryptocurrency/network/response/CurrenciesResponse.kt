package by.tolikavre.cryptocurrency.network.response

import by.tolikavre.cryptocurrency.model.latest.ResultEntry
import com.google.gson.annotations.SerializedName

data class CurrenciesResponse(
  @SerializedName("data")
  val resultEntry: List<ResultEntry>
)