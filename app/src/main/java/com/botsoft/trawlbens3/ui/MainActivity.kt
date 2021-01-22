package com.botsoft.trawlbens3.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.botsoft.trawlbens3.R
import com.botsoft.trawlbens3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val topDestination = setOf(R.id.listFragment)
        navController = findNavController(R.id.fragment_nav)
        appBarConfiguration = AppBarConfiguration(topDestination)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
    }
}