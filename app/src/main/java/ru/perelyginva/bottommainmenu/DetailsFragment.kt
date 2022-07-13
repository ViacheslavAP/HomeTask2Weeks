package ru.perelyginva.bottommainmenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.perelyginva.bottommainmenu.databinding.FragmentDetailsBinding


class DetailsFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)

        binding.tvNameDetails .text = arguments?.getString(Const.NAME_MOVIES).toString()
        binding.tvDurationDetails.text = arguments?.getString(Const.DURATIONS_MOVIES).toString()
        binding.tvActorsDetails.text = arguments?.getString(Const.NAME_ACTORS_MOVIES).toString()

        when(binding.tvNameDetails.text){
            getString(R.string.terminator) ->
                binding.imDetails.setImageResource(R.drawable.terminator)
        }

        binding.imClose.setOnClickListener {
          dismiss()
        }

        return binding.root
    }


}