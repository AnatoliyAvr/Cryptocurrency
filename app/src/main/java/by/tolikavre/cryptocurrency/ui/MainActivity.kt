package by.tolikavre.cryptocurrency.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import by.tolikavre.cryptocurrency.R
import by.tolikavre.cryptocurrency.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  lateinit var toolbar: Toolbar
  lateinit var navController: NavController
  private var _binding: ActivityMainBinding? = null
  private val binding get() = _binding!!

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    _binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
    toolbar = binding.toolbar
    navController = Navigation.findNavController(this, R.id.nav_host_fragment)
    setSupportActionBar(toolbar)
    title = getString(R.string.title)

    binding.bottomNav.setupWithNavController(navController)
    NavigationUI.setupActionBarWithNavController(this, navController)
  }

  override fun onSupportNavigateUp(): Boolean {
    return NavigationUI.navigateUp(navController, null)
  }

  override fun onDestroy() {
    super.onDestroy()
    _binding = null
  }
}