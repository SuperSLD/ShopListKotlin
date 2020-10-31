package pro.midev.gurmanica.di

import com.cgroup.shoplistkotlin.common.CiceroneHolder
import com.cgroup.shoplistkotlin.data_managers.ShopListManager
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.realm.Realm
import io.realm.RealmConfiguration
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import java.util.logging.Level
import java.util.logging.Logger

val appModule = module {

    single {
        OkHttpClient.Builder()
            .connectTimeout(40, TimeUnit.SECONDS)
            .readTimeout(40, TimeUnit.SECONDS)
            .build()
    }

    single {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(get())
    }

    single {
        CiceroneHolder()
    }

    single {
        ShopListManager().init()
    }
}