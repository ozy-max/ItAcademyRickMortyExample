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
import com.example.itacademyrickmortyexample.models.Heroes
import com.example.itacademyrickmortyexample.retrofit.RetrofitService
import com.example.itacademyrickmortyexample.utils.Common
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private lateinit var service: RetrofitService
private lateinit var adapter: MyAdapter
private lateinit var recHero: RecyclerView

class HeroListFragment : BaseFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hero_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = MyAdapter(onClick = { re(it) })

        recHero = recHero.findViewById(R.id.recHero)
        service = Common.retrofitService
        // adapter = MyAdapter(onClick = { startInfoActivity(it) })
        recHero.layoutManager = LinearLayoutManager(context)
        recHero.adapter = adapter
        getAllHeroes()
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
                    context,
                    "We`ve some error${t.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}