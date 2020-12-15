package by.tolikavre.cryptocurrency

import android.app.Application
import by.tolikavre.cryptocurrency.db.CurrenciesDatabase
import by.tolikavre.cryptocurrency.network.*
import by.tolikavre.cryptocurrency.repository.CurrenciesRepository
import by.tolikavre.cryptocurrency.repository.CurrenciesRepositoryImpl
import by.tolikavre.cryptocurrency.ui.list.ListCurrenciesViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class App : Application(), KodeinAware {

  override val kodein = Kodein.lazy {
    import(androidXModule(this@App))

    bind() from singleton { CurrenciesDatabase(instance()) }
    bind() from singleton { instance<CurrenciesDatabase>().currenciesDao() }
    bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
    bind() from singleton { NetworkService(instance()) }
    bind<CurrenciesNetworkDataSource>() with singleton { CurrenciesNetworkDataSourceImpl(instance()) }
    bind<CurrenciesRepository>() with singleton { CurrenciesRepositoryImpl(instance(), instance()) }
    bind() from singleton { ListCurrenciesViewModelFactory(instance()) }
  }
}