package ru.perelyginva.bottommainmenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import ru.perelyginva.bottommainmenu.databinding.FragmentHomeBinding


class HomeFragment : Fragment(), View.OnClickListener {

    private var binding: FragmentHomeBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
       binding = FragmentHomeBinding.inflate(layoutInflater, container, false)


        binding?.cardMovies?.setOnClickListener(this)



        return binding?.root
    }

    override fun onClick(view: View?) {

        val details = DetailsFragment()
        val param = Bundle()
        param.putString("name_movies", binding?.tvMoviesTitle?.text.toString())
        param.putString("duration_movies", binding?.tvMoviesDuration?.text.toString())
        param.putString("actors_movies", binding?.tvMoviesActors?.text.toString())
        details.arguments = param
        details.show((context as FragmentActivity).supportFragmentManager, "details")
    }

}