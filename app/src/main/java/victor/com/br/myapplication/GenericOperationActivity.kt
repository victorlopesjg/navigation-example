package com.ebankit.android.smartizi.view.activity.privateZone

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.Navigation
import java.util.*


/**

Copyright (c) 15/10/2019 ITSector Software. All rights reserved.
ITSector Software Confidential and Proprietary information. It is strictly forbidden for 3rd
parties to modify, decompile, disassemble, defeat, disable or circumvent any protection
mechanism; to sell, license, lease, rent, redistribute or make accessible to any third party,
whether for profit or without charge.

Created by Victor Oliveira on 15/10/2019.

ITSector
victor.oliveira@itsector.pt
 */
abstract class GenericOperationActivity<D : ViewDataBinding> : AppCompatActivity(), NavController.OnDestinationChangedListener {
    protected lateinit var dataBinding: D

    protected lateinit var navController: NavController
    protected lateinit var graph: NavGraph

    protected var operationTypeInt: Int = 0


    protected abstract val toolbar: Toolbar

    protected abstract val toolbarTitle: TextView

    @get:LayoutRes
    protected abstract val layoutRes: Int

    @get:LayoutRes
    abstract val resNavigation: Int

    @SuppressLint("WrongViewCast", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, layoutRes)
        navController = Navigation.findNavController(this, resNavigation)

    }

    override fun onStart() {
        super.onStart()
        setSupportActionBar(toolbar)

        Objects.requireNonNull<ActionBar>(supportActionBar).setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

    }

    override fun onResume() {
        super.onResume()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onDestinationChanged(controller: NavController, destination: NavDestination, arguments: Bundle?) {
        if (destination.id == controller.graph.startDestination) {
            Objects.requireNonNull<ActionBar>(supportActionBar).setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
            supportActionBar!!.setDisplayShowTitleEnabled(false)
        }
    }


}

