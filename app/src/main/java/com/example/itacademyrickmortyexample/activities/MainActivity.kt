package com.example.itacademyrickmortyexample.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

class MainActivity : AppCompatActivity() {

    private lateinit var service:RetrofitService
    private lateinit var adapter:MyAdapter
    private lateinit var recHero:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recHero = findViewById(R.id.recHero)
        service = Common.retrofitService
       // adapter = MyAdapter(onClick = { startInfoActivity(it) })
        recHero.layoutManager = LinearLayoutManager(this)
        recHero.adapter = adapter
        getAllHeroes()
    }
    private fun getAllHeroes(){
        service.getHeroList().enqueue(object : Callback<Heroes>{
            override fun onResponse(call: Call<Heroes>, response: Response<Heroes>) {
                if (response.isSuccessful && response.body() != null){
                    val hero = response.body()!!
                    adapter.setItems(hero.results)
                }
            }

            override fun onFailure(call: Call<Heroes>, t: Throwable) {
                Log.e("Error from response","error!!!!",t)
                Toast.makeText(this@MainActivity,"We`ve some error${t.message}",Toast.LENGTH_SHORT).show()
            }
        })
    }
    /**
     * 1 Перейти на фрагменты
     * 2 При повороте запомнить стэйт курсора , чтобы приложение запоминало состояние.
     * 3 При нажатии на иконку,открывается информация о герое.
     * 4 Добавить поля в item_view.xml
     */
}