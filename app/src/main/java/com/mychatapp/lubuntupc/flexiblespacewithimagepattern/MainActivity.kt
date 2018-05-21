package com.mychatapp.lubuntupc.flexiblespacewithimagepattern

import android.graphics.BitmapFactory
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.support.design.widget.AppBarLayout
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v7.graphics.Palette
import android.util.Log
import android.view.Menu
import android.view.MenuItem



class MainActivity : AppCompatActivity() {

    var appBarExpanded: Boolean = true
    var collapsedMenu: Menu? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1BARDZO WAZNE - bez tego nie działa onCreateOptionsMenu
        //2 zeby przycisk add (plus) dodadawał się - menu musi mieć jeden item - może być niewidzialny!
        setSupportActionBar(toolbarId)
        supportActionBar!!.setDisplayShowTitleEnabled(false)


        appbar.addOnOffsetChangedListener(object: AppBarLayout.OnOffsetChangedListener {
            override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
                if (Math.abs(verticalOffset) > 200) {
                    appBarExpanded = false
                    invalidateOptionsMenu()

                } else {
                    appBarExpanded = true
                    invalidateOptionsMenu()

                }
            }
        })


    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        if (collapsedMenu != null && (!appBarExpanded || collapsedMenu!!.size() != 1)) {

            //collapsed
            collapsedMenu!!.add("Add")
                    .setIcon(R.drawable.ic_action_add)
                    .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM)
        } else {
            //expanded
        }


        return super.onPrepareOptionsMenu(collapsedMenu)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        getMenuInflater().inflate(R.menu.menu_main, menu)
        collapsedMenu = menu
        return true
    }


}
