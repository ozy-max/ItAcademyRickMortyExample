package com.example.itacademyrickmortyexample.activities

import android.os.Bundle
import com.example.itacademyrickmortyexample.R
import com.example.itacademyrickmortyexample.base.RickAndMortyFragment

class MainActivity : BaseActivity() {
    private val rickAndMortyFragment = RickAndMortyFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(rickAndMortyFragment)
    }

}
/**
 * 1 Перейти на фрагменты
 * 2 При повороте запомнить стэйт курсора , чтобы приложение запоминало состояние.
 * 3 При нажатии на иконку,открывается информация о герое.
 * 4 Добавить поля в item_view.xml DONE
 */
