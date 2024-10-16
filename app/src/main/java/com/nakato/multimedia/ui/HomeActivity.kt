package com.nakato.multimedia.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.nakato.multimedia.R
import com.nakato.multimedia.databinding.ActivityHomeBinding

//import com.nakato.multimedia.R
//import com.nakato.multimedia.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        }

    override fun onResume() {
        super.onResume()
        binding.bnvHome.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.home->{
                   loadFragment(HomeFragment())
                }
                R.id.games->{
                    loadFragment(GamesFragment())
                }
                R.id.settings->{
                    loadFragment(SettingsFragment())
                }
                R.id.profile ->{
                    loadFragment(ProfileFragment())
                }
                else ->{
                    loadFragment(HomeFragment())
                }

            }

        }
    }
    fun loadFragment(fragment: Fragment): Boolean{
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fcvHome,fragment)
        fragmentTransaction.commit()
        return true
    }
    }
