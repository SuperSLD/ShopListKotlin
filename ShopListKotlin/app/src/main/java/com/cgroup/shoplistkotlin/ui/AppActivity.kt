package com.cgroup.shoplistkotlin.ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.arellomobile.mvp.MvpAppCompatActivity
import com.cgroup.shoplistkotlin.R
import com.cgroup.shoplistkotlin.Screens
import pro.midev.gurmanica.common.base.BaseFragment

class AppActivity : MvpAppCompatActivity() {
    private val currentFragment: BaseFragment?
        get() = supportFragmentManager.findFragmentById(R.id.container) as? BaseFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            initTransparent()
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_container)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, Screens.FlowGlobal.fragment)
                .commitNow()
        }
    }

    override fun onBackPressed() {
        currentFragment?.onBackPressed() ?: super.onBackPressed()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun initTransparent() {
        window.apply {
            decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                decorView.systemUiVisibility = decorView.systemUiVisibility or
                        View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR or
                        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }

            statusBarColor = ContextCompat.getColor(context, R.color.colorStatusBar)
            navigationBarColor = ContextCompat.getColor(context, R.color.colorNavigationBar)
        }
    }
}