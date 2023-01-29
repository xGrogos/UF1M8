package com.xgrogos.uf1m8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.xgrogos.uf1m8.DB.LolDBHelper

class BottomNavigation : AppCompatActivity() {
    companion object {
        lateinit var dbHelper:LolDBHelper;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        val bottomNav: BottomNavigationView = findViewById(R.id.main_menu)

        val dbHelper = LolDBHelper(this)


        bottomNav.setOnNavigationItemSelectedListener() { item: MenuItem ->
            when (item.itemId) {
                R.id.nav_home -> {
                    loadFragment(Home())
                    true
                }

                R.id.nav_form -> {
                    loadFragment(Form(dbHelper))
                    true
                }

                R.id.nav_list -> {
                    loadFragment(List(dbHelper))
                    true
                }
                else -> {false}
            }
        }


    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onDestroy() {
        dbHelper.close()
        super.onDestroy()
    }

}