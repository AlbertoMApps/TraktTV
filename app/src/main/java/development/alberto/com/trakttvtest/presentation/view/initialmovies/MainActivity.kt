package development.alberto.com.trakttvtest.presentation.view.initialmovies

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
import android.view.MenuItem
import development.alberto.com.trakttvtest.R
import development.alberto.com.trakttvtest.data.model.realmobject.ImageMovieDetails
import development.alberto.com.trakttvtest.data.model.realmobject.RealmGenre
import development.alberto.com.trakttvtest.presentation.adapter.ListMovieDetailsAdapter
import development.alberto.com.trakttvtest.presentation.presenter.initialmovies.PresenterListMovieMainScreen
import development.alberto.com.trakttvtest.presentation.view.moviedetails.MainMovieDetails
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity() , ViewActivity {

    lateinit var presenterListMovieMainScreen: PresenterListMovieMainScreen
    lateinit var listMovieDetailsAdapter: ListMovieDetailsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, R.string.fab_message, Snackbar.LENGTH_LONG)
                    .setAction(R.string.fab_action, null).show()
        }



        presenterListMovieMainScreen = PresenterListMovieMainScreen(this)
        presenterListMovieMainScreen.onCreate()
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
    //initially show the list of images in the viewActivity
    override fun showMovieListInView(imageMovieDetails:List<ImageMovieDetails>) {
        //update the viewActivity
        updateRecyclerListMovieDetails(imageMovieDetails)
    }


    private fun updateRecyclerListMovieDetails (imageMovieDetails:List<ImageMovieDetails>) {
        listMovieDetailsAdapter = ListMovieDetailsAdapter(this, R.layout.images_row, imageMovieDetails)
        imagesListView.setAdapter(listMovieDetailsAdapter)
        imagesListView.setLayoutManager( GridLayoutManager(this, 2) )
    }

    //receive the details of the actual position in the list when it is clicked
    // and send them to MovieDetails for representation
    fun receiveActualPositionListClickToDisplay(actualImageDetails: ImageMovieDetails) {
        val intent = Intent(this@MainActivity, MainMovieDetails::class.java)
//        toBundle(actualImageDetails)
        intent.putExtra(MainMovieDetails.EXTRA_MOVIE_TITLE, actualImageDetails.title)
        intent.putExtra(MainMovieDetails.EXTRA_MOVIE_OVERVIEW, actualImageDetails.overview)
        intent.putExtra(MainMovieDetails.EXTRA_MOVIE_RELEASE_DATE, actualImageDetails.releaseDate)
        intent.putExtra(MainMovieDetails.EXTRA_POSTER_PATH, actualImageDetails.posterPath)
        intent.putExtra(MainMovieDetails.EXTRA_VOTE_AVERAGE, actualImageDetails.voteAverage.toString())
        var genreNames:String = ""
        //toString
        for (genre:RealmGenre in actualImageDetails.genres!!){
            genreNames += genre.name + "  "
        }
        intent.putExtra(MainMovieDetails.EXTRA_GENRES, genreNames)
        //startActivityMainMovieDetails
        startActivity(intent)
    }
}
