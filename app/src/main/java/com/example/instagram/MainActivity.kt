package com.example.instagram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.instagram.fragment.HomeFragment
import com.example.instagram.fragment.NotificationFragment
import com.example.instagram.fragment.ProfileFragment
import com.example.instagram.fragment.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    //untuk mengaktifkan bottom navigation di activity
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when(item.itemId){
            R.id.nav_home ->{
                moveToFragment(HomeFragment())
                return@OnNavigationItemSelectedListener true
            }

            R.id.nav_search ->{
                moveToFragment(SearchFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_add_post ->{
                item.isChecked
                startActivity(Intent(this,TambahPostActivity::class.java))
                return@OnNavigationItemSelectedListener  true
            }

            R.id.nav_notification ->{
                moveToFragment(NotificationFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_profile ->{
                moveToFragment(ProfileFragment())
                return@OnNavigationItemSelectedListener true
            }
        }

        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //untuk membuild bottom navigationnya
        val navView:BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        //supaya home menjadi default
        moveToFragment(HomeFragment())
    }
    // function untuk pindah antar fragment
    private fun moveToFragment(fragment: Fragment) {
       val fragmentTrans = supportFragmentManager.beginTransaction()
        fragmentTrans.replace(R.id.fragment_container, fragment)
        fragmentTrans.commit()
    }
}