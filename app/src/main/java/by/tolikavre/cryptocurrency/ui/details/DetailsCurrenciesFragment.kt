package by.tolikavre.cryptocurrency.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import by.tolikavre.cryptocurrency.databinding.DetailsCurrenciesFragmentBinding

class DetailsCurrenciesFragment : Fragment() {

  private var _binding: DetailsCurrenciesFragmentBinding? = null
  private val binding get() = _binding!!
  private lateinit var viewModel: DetailsCurrenciesViewModel

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = DetailsCurrenciesFragmentBinding.inflate(layoutInflater, container, false)
    return binding.root
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    initialization()
  }

  private fun initialization() {
    viewModel = ViewModelProvider(this)
      .get(DetailsCurrenciesViewModel::class.java)
  }
}