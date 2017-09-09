package development.alberto.com.trakttvtest

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by alber on 09/09/2017.
 */


class  TraktApplication: Application() {


    override fun onCreate() {
        super.onCreate()
        initRealm()
    }

    private fun initRealm() {
        Realm.init(applicationContext)

        val config = RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build()
        Realm.setDefaultConfiguration(config)
    }
}