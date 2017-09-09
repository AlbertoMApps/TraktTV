package development.alberto.com.trakttvtest.presentation.presenter

/**
 * Created by alber on 09/09/2017.
 */

interface Presenter {
    fun onCreate()
    fun onResume()
    fun onPause()
    fun onDestroy()
}