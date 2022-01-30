package com.example.foody.ui.fragments.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import coil.load
import com.example.foody.R
import com.example.foody.databinding.FragmentInstructionsBinding
import com.example.foody.databinding.FragmentOverviewBinding
import com.example.foody.models.Result
import com.example.foody.util.Constants.Companion.RECIPE_RESULT_KEY
import org.jsoup.Jsoup


class OverviewFragment : Fragment() {

    private var _binding: FragmentOverviewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentOverviewBinding.inflate(inflater, container, false)

        val args = arguments
        val myBundle: Result? = args?.getParcelable(RECIPE_RESULT_KEY)

        binding.mainImageView.load(myBundle?.image)
        binding.titleTextView.text = myBundle?.title
        binding.likesTextView.text = myBundle?.aggregateLikes.toString()
        binding.timeTextView.text = myBundle?.readyInMinutes.toString()
        myBundle?.summary.let {
            val summary = Jsoup.parse(it).text()
            binding.summaryTextView.text = summary
        }

        // Vegetarian Checkmarks
        if(myBundle?.vegetarian == true) {
            binding.vegetarianImageView.setColorFilter((ContextCompat.getColor(requireContext(), R.color.green)))
            binding.veganTextView.setTextColor((ContextCompat.getColor(requireContext(), R.color.green)))
        }

        // Vegan Checkmarks
        if(myBundle?.vegan == true) {
            binding.veganImageView.setColorFilter((ContextCompat.getColor(requireContext(), R.color.green)))
            binding.veganTextView.setTextColor((ContextCompat.getColor(requireContext(), R.color.green)))
        }

        // Gluten Free Checkmarks
        if(myBundle?.glutenFree == true) {
            binding.glutenFreeImageView.setColorFilter((ContextCompat.getColor(requireContext(), R.color.green)))
            binding.glutenFreeTextView.setTextColor((ContextCompat.getColor(requireContext(), R.color.green)))
        }

        // Dairy Free Checkmarks
        if(myBundle?.dairyFree == true) {
            binding.dairyFreeImageView.setColorFilter((ContextCompat.getColor(requireContext(), R.color.green)))
            binding.dairyFreeTextView.setTextColor((ContextCompat.getColor(requireContext(), R.color.green)))
        }


        // Healthy Checkmarks
        if(myBundle?.veryHealthy == true) {
            binding.healtyImageView.setColorFilter((ContextCompat.getColor(requireContext(), R.color.green)))
            binding.healthyTextView.setTextColor((ContextCompat.getColor(requireContext(), R.color.green)))
        }

        // Cheap Checkmarks
        if(myBundle?.cheap == true) {
            binding.cheapImageView.setColorFilter((ContextCompat.getColor(requireContext(), R.color.green)))
            binding.cheapTextView.setTextColor((ContextCompat.getColor(requireContext(), R.color.green)))
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}