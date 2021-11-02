package com.example.itacademyrickmortyexample.base

import android.os.Bundle
import android.text.util.Linkify
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.itacademyrickmortyexample.databinding.FragmentInfoBinding
import com.example.itacademyrickmortyexample.models.Result
import com.squareup.picasso.Picasso

private lateinit var binding: FragmentInfoBinding
private lateinit var dataResult: Result

class InfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInfoBinding.inflate(inflater, container, false)
        dataResult = requireArguments().getParcelable("heroes")!!
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Picasso.get().load(dataResult.image).into(binding.roundedImage)
        binding.nameTextView.text = dataResult.name
        binding.statusTextView.text = dataResult.status
        binding.speciesTextView.text = dataResult.species
        binding.maleTextView.text = dataResult.gender
        binding.locationTextView.text = dataResult.location.name
        binding.originTextView.text = dataResult.origin.name
        binding.EpisodeTextView.text = dataResult.episode.size.toString()
        Linkify.addLinks(binding.EpisodeTextView, Linkify.WEB_URLS);
    }
}
