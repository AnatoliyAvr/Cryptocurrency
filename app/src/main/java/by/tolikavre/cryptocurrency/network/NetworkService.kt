package by.tolikavre.cryptocurrency.network

import by.tolikavre.cryptocurrency.network.response.CurrenciesResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "2ed39291-a3d8-4093-8067-1a62e87fddd8"

interface NetworkService {

  @GET("cryptocurrency/listings/latest?")
  fun getListCurrencies(
    @Query("limit") limit: String = "10",
    @Query("convert") convert: String = "USD"
  ): Deferred<CurrenciesResponse>

  companion object {
    operator fun invoke(
      connectivityInterceptor: ConnectivityInterceptor
    ): NetworkService {
      val requestInterceptor = Interceptor { chain ->

        val url = chain.request()
          .url()
          .newBuilder()
          .addQueryParameter("CMC_PRO_API_KEY", API_KEY)
          .build()

        val request = chain.request()
          .newBuilder()
          .url(url)
          .build()

        return@Interceptor chain.proceed(request)
      }

      val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(requestInterceptor)
        .addInterceptor(connectivityInterceptor)
        .build()

      return Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://pro-api.coinmarketcap.com/v1/")
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NetworkService::class.java)
    }
  }
}