package com.example.itacademyrickmortyexample.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.itacademyrickmortyexample.databinding.FragmentInfoBinding
import com.example.itacademyrickmortyexample.models.Result

private lateinit var binding: FragmentInfoBinding

class InfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        var fragment = InfoFragment().apply {
//
//        }
//        val data: Result by lazy { arguments?.getParcelable("dataKey")!! as Result }

    }

//    companion object {
//        fun newInstance(yourData: Result) =
//            InfoFragment().apply {
//                arguments = Bundle().apply { putParcelable("dataKey", yourData) }
//            }
//    }
}