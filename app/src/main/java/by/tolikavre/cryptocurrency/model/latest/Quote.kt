package by.tolikavre.cryptocurrency.model.latest

import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

data class Quote(
    @SerializedName("USD")
    @Embedded
    val uSD: USD
)