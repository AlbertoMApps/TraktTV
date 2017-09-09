package development.alberto.com.trakttvtest.presentation

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import development.alberto.com.trakttvtest.R
import development.alberto.com.trakttvtest.data.datarepository.DataTraktTmdbRepository

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, R.string.fab_message, Snackbar.LENGTH_LONG)
                    .setAction(R.string.fab_action, null).show()
        }

        //Call to check the service...
        var dataTrakt:DataTraktTmdbRepository = DataTraktTmdbRepository()
        dataTrakt.getDataRepositoryMerged()
        dataTrakt.observableListImageMoviesDetailsCached()
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
}