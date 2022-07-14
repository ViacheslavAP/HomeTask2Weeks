package ru.perelyginva.bottommainmenu

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.FragmentActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.perelyginva.bottommainmenu.databinding.FragmentMainMenuBinding


class MainMenuFragment : BottomSheetDialogFragment() {

    private var binding: FragmentMainMenuBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMainMenuBinding.inflate(layoutInflater, container, false)

        binding?.navView?.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {

                R.id.homeMenu -> {
                    val startHome = Intent(context, MainActivity::class.java)
                    val activityOptionsCompat =
                        ActivityOptionsCompat.makeSceneTransitionAnimation((context as FragmentActivity))
                    startActivity(startHome, activityOptionsCompat.toBundle())
                }

                R.id.shopMenu -> {

                }

                R.id.favoritesMenu -> {

                }

                R.id.accountMenu -> {

                }


                R.id.videoMenu -> {

                }


                R.id.locationMenu -> {
                }

                R.id.settingsMenu -> {
                }

                R.id.contactsMenu -> {

                }

                R.id.helpsMenu -> {

                }

            }
            true
        }
        return binding!!.root
    }

}