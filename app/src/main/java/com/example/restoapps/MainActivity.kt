package com.example.restoapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.restoapps.cashier.CashierFragment
import com.example.restoapps.databinding.ActivityMainBinding
import com.example.restoapps.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarCustom)
        val toogleAction = ActionBarDrawerToggle(
            this,
            binding.drawerLay,
            binding.toolbarCustom,
            R.string.nav_drawer_open,
            R.string.nav_drawer_close
        )
        binding.drawerLay.addDrawerListener(toogleAction)
        toogleAction.syncState()

        binding.navContainer.setNavigationItemSelectedListener{ menu ->
            when(menu.itemId){
                R.id.nav_home ->{
                    setFragment(HomeFragment(), getString(R.string.title_home))
                }
                R.id.nav_cashier->{
                    setFragment(CashierFragment(), getString(R.string.title_cashier))
                }
            }
            binding.drawerLay.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true
        }

        if (savedInstanceState == null){
            setFragment(HomeFragment(),getString(R.string.title_home))
        }
    }

    fun setFragment(fragment: Fragment, title: String){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
        supportActionBar?.title = title
    }
}