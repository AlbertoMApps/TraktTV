package development.alberto.com.trakttvtest.presentation.view

import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import development.alberto.com.trakttvtest.R
import development.alberto.com.trakttvtest.data.model.realmobject.ImageMovieDetails
import development.alberto.com.trakttvtest.presentation.presenter.PresenterListMovieDetails
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , View {

    lateinit var presenterListMovieDetails:PresenterListMovieDetails


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, R.string.fab_message, Snackbar.LENGTH_LONG)
                    .setAction(R.string.fab_action, null).show()
        }

        presenterListMovieDetails = PresenterListMovieDetails(this)
        presenterListMovieDetails.onCreate()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun context(): Context {
        return this
    }

    override fun showMovieListInView(imageMovieDetails:List<ImageMovieDetails>) {
        //update the view

    }
}
