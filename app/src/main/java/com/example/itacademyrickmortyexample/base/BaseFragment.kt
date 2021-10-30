package com.example.itacademyrickmortyexample.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction


abstract class BaseFragment : Fragment() {

    fun  changeFragment(fragment: Fragment, id: Int) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.replace(id, fragment)
        fragmentTransaction.commit()
    }
}