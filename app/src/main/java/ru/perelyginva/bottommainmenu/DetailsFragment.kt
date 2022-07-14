package ru.perelyginva.bottommainmenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.perelyginva.bottommainmenu.databinding.FragmentDetailsBinding


class DetailsFragment : BottomSheetDialogFragment() {

    private var binding: FragmentDetailsBinding? = null


    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)

        binding?.tvNameDetails?.text = arguments?.getString("name_movies").toString()
        binding?.tvDurationDetails?.text = arguments?.getString("duration_movies").toString()
        binding?.tvActorsDetails?.text = arguments?.getString("actors_movies").toString()

        when(binding?.tvNameDetails?.text){
            getString(R.string.terminator) ->
                binding?.imDetails?.setImageResource(R.drawable.terminator)
        }

        binding?.imClose?.setOnClickListener(View.OnClickListener{
            dismiss()
        })



        return binding?.root
    }

}