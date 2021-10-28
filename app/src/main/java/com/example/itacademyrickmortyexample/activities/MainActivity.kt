package com.example.itacademyrickmortyexample.activities

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.itacademyrickmortyexample.base.BaseActivity
import com.example.itacademyrickmortyexample.base.HeroListFragment

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        replaceFragment(HeroListFragment())
    }
}