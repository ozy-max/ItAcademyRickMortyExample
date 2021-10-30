package com.example.itacademyrickmortyexample.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.itacademyrickmortyexample.R
import com.example.itacademyrickmortyexample.adapter.MyAdapter
import com.example.itacademyrickmortyexample.databinding.FragmentRickAndMortyBinding
import com.example.itacademyrickmortyexample.models.Heroes
import com.example.itacademyrickmortyexample.models.Result
import com.example.itacademyrickmortyexample.retrofit.RetrofitService
import com.example.itacademyrickmortyexample.utils.Common
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private lateinit var service: RetrofitService
private lateinit var adapter: MyAdapter
private lateinit var recHero: RecyclerView
private lateinit var binding: FragmentRickAndMortyBinding

class RickAndMortyFragment : BaseFragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRickAndMortyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        service = Common.retrofitService
        adapter = MyAdapter(onClick = { changeFragment(InfoFragment(), R.id.frame_layout) })
        binding.recViewHero.layoutManager = LinearLayoutManager(context)
        binding.recViewHero.adapter = adapter
        getAllHeroes()
//        arguments = Bundle().apply { putParcelable("dataKey", Result) }
    }



    private fun getAllHeroes() {
        service.getHeroList().enqueue(object : Callback<Heroes> {
            override fun onResponse(call: Call<Heroes>, response: Response<Heroes>) {
                if (response.isSuccessful && response.body() != null) {
                    val hero = response.body()!!
                    adapter.setItems(hero.results)
                }
            }

            override fun onFailure(call: Call<Heroes>, t: Throwable) {
                Log.e("Error from response", "error!!!!", t)
                Toast.makeText(
                    requireContext(),
                    "We`ve some error${t.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}
