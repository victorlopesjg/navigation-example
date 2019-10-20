package victor.com.br.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.ebankit.android.smartizi.view.activity.privateZone.GenericOperationActivity
import victor.com.br.myapplication.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity(), NavController.OnDestinationChangedListener {

    lateinit var navController: NavController
    lateinit var graph: NavGraph
    lateinit var dataBinding: ActivityMainBinding

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        navController = Navigation.findNavController(this, R.id.generic_operation_host_fragment)

        val navInflater = navController.navInflater

        graph = navInflater.inflate(R.navigation.service_pay_navigation)
        graph.id = R.navigation.service_pay_navigation

        graph.startDestination = R.id.navigation_bill_payments

        navController.graph = graph

        setSupportActionBar(dataBinding.toolbar)

        NavigationUI.setupActionBarWithNavController(this, navController)
        navController.addOnDestinationChangedListener(this)

    }

    override fun onStart() {
        super.onStart()

        setSupportActionBar(dataBinding.toolbar)

        Objects.requireNonNull<ActionBar>(supportActionBar).setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        if (destination.id == controller.graph.startDestination) {
            Objects.requireNonNull<ActionBar>(supportActionBar).setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
            supportActionBar!!.setDisplayShowTitleEnabled(false)
            supportActionBar!!.setTitle(destination.label)
        }
    }

}
