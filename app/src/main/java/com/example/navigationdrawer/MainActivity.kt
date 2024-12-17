package com.example.navigationdrawer

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.myDrawer_layout)

        actionBarDrawerToggle =
            ActionBarDrawerToggle(
                this,
                drawerLayout,R.string.nav_open,
                R.string.nav_close)

        drawerLayout.addDrawerListener(actionBarDrawerToggle)

        actionBarDrawerToggle.syncState()

        // exibe ícone do menu e ícone para voltar quando drawer está aberto
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    //adiciona a "..."com as opções do menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.my_drawer_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // check conndition for drawer item with menu item
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)){
            true
        }else{
            super.onOptionsItemSelected(item)
        }

    }
}