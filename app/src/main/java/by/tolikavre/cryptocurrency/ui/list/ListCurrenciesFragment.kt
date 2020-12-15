package by.tolikavre.cryptocurrency.ui.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import by.tolikavre.cryptocurrency.R
import by.tolikavre.cryptocurrency.databinding.ListCurrenciesFragmentBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class ListCurrenciesFragment : Fragment(), KodeinAware {
  override val kodein by kodein()
  private val listCurrenciesViewModelFactory: ListCurrenciesViewModelFactory by instance()

  private var _binding: ListCurrenciesFragmentBinding? = null
  private val binding get() = _binding!!
  private lateinit var viewModel: ListCurrenciesViewModel
  private lateinit var recyclerView: RecyclerView
  private lateinit var currenciesAdapter: ListCurrenciesAdapter

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = ListCurrenciesFragmentBinding.inflate(layoutInflater, container, false)
    return binding.root
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    initialization()
  }

  private fun initialization() {
    currenciesAdapter = ListCurrenciesAdapter {
      this.findNavController().navigate(R.id.action_listCurrenciesFragment_to_detailsCurrenciesFragment)
    }
    recyclerView = binding.recyclerView
    recyclerView.adapter = currenciesAdapter

    viewModel = ViewModelProvider(this, listCurrenciesViewModelFactory)
      .get(ListCurrenciesViewModel::class.java)

    GlobalScope.launch(Dispatchers.Main) {
      val currencies = viewModel.currencies.await()
      currencies.observe(viewLifecycleOwner, {
        currenciesAdapter.setList(it)
      })
    }
  }
}