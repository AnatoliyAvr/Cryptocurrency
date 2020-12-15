package by.tolikavre.cryptocurrency.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.tolikavre.cryptocurrency.databinding.ItemListCurrencyBinding
import by.tolikavre.cryptocurrency.db.unitlocolized.UnitCurrenciesEntry
import com.bumptech.glide.Glide

class ListCurrenciesAdapter(private val listener: (UnitCurrenciesEntry) -> Unit) :
  RecyclerView.Adapter<ListCurrenciesAdapter.ListViewHolder>() {

  private var listCurrencies = emptyList<UnitCurrenciesEntry>()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
    val layoutInflater = LayoutInflater.from(parent.context)
    val itemCurrencyBinding = ItemListCurrencyBinding.inflate(layoutInflater, parent, false)
    return ListViewHolder(itemCurrencyBinding)
  }

  override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
    holder.bind(listCurrencies[position], listener)
  }

  override fun getItemCount(): Int = listCurrencies.size

  inner class ListViewHolder(private val itemCurrencyBinding: ItemListCurrencyBinding) :
    RecyclerView.ViewHolder(itemCurrencyBinding.root) {

    fun bind(currencies: UnitCurrenciesEntry, listener: (UnitCurrenciesEntry) -> Unit) {

      Glide.with(itemView)
        .load("https://s2.coinmarketcap.com/static/img/coins/64x64/${currencies.id}.png")
        .into(itemCurrencyBinding.ivCryptocurrency)

      itemCurrencyBinding.tvCurrencyName.text = currencies.name
      itemCurrencyBinding.tvCurrencyPrice.text = currencies.quote.uSD.price.toString()

      itemView.setOnClickListener {
        listener.invoke(currencies)
      }
    }
  }

  fun setList(tempResponse: List<UnitCurrenciesEntry>) {
    listCurrencies = tempResponse
    notifyDataSetChanged()
  }
}