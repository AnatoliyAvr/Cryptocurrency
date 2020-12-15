package by.tolikavre.cryptocurrency.ui.converter

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.tolikavre.cryptocurrency.databinding.CryptocurrencyConverterFragmentBinding

class CryptocurrencyConverterFragment : Fragment() {

  private var _binding: CryptocurrencyConverterFragmentBinding? = null
  private val binding get() = _binding!!
  private lateinit var viewModel: CryptocurrencyConverterViewModel

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = CryptocurrencyConverterFragmentBinding.inflate(layoutInflater, container, false)
    return binding.root
  }

  override fun onStart() {
    super.onStart()
    initialization()
  }

  private fun initialization() {
    setHasOptionsMenu(true)
    viewModel = ViewModelProvider(this).get(CryptocurrencyConverterViewModel::class.java)
  }
}