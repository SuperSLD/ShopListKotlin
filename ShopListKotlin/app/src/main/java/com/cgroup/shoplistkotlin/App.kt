package com.cgroup.shoplistkotlin

import android.app.Application
import android.os.Build
import android.view.View
import androidx.core.content.ContextCompat
import io.realm.Realm
import io.realm.RealmConfiguration
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.inject
import pro.midev.gurmanica.di.appModule
import java.util.logging.Level
import java.util.logging.Logger

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        super.onCreate()
        initKoin()
        initRealm()
    }

    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModule)
        }
    }

    private fun initRealm() {
        Realm.init(this.applicationContext)
        val config = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .name("shop_list.db")
            .build()
        Realm.getInstance(config)
        Logger.getLogger("shoplog").log(Level.INFO, "Realm initialisation finish")
    }
}