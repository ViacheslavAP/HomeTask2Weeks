package ru.perelyginva.bottommainmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import ru.perelyginva.bottommainmenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        _binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        setSupportActionBar(binding.topAppBar)//не забывать включать при работе с барами

        binding.cardMovies.setOnClickListener {

            val details = DetailsFragment()
            val  param = Bundle()
            param.putString(Const.NAME_MOVIES, binding.tvMoviesTitle.text.toString())
            param.putString(Const.DURATIONS_MOVIES, binding.tvMoviesDuration.text.toString())
            param.putString(Const.NAME_ACTORS_MOVIES, binding.tvMoviesActors.text.toString())
            details.arguments = param
            details.show(supportFragmentManager, Const.DETAILS)

        }

        binding.topAppBar.setOnMenuItemClickListener { menuItem: MenuItem ->
            when (menuItem.itemId) {
                R.id.favoritesItemTopNav -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.content, FavoritesFragment()).commit()
                    true
                }

                R.id.settingsItemTopNav -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.content, SettingsFragment()).commit()
                    true
                }
                else -> {
                    false
                }
            }
        }

        binding.bottomNavView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeBottomMenu -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.content, HomeFragment()).commit()
                }

                R.id.catalogBottomMenu -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.content, CatalogFragment()).commit()
                }

                R.id.deliveryBottomMenu -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.content, DeliveryFragment()).commit()
                }

                R.id.contactsBottomMenu -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.content, ContactsFragment()).commit()
                }
                else -> {}
            }
            return@setOnItemSelectedListener true
        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.top_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            android.R.id.home -> {

                val mainMenu = MainMenuFragment()
                mainMenu.show(
                    supportFragmentManager,
                    "main_menu")

            }

        }

        return true
    }
}