package development.alberto.com.trakttvtest.presentation.view.moviedetails

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.squareup.picasso.Picasso
import development.alberto.com.trakttvtest.R
import kotlinx.android.synthetic.main.movie_details.*


/**
 * Created by alber on 09/09/2017.
 */

class MainMovieDetails : AppCompatActivity() , ViewMovieDetails {

    companion object IntentOptions {
        const val EXTRA_MOVIE_TITLE = "MovieTitle"
        const val EXTRA_MOVIE_OVERVIEW = "MovieOverview"
        const val EXTRA_MOVIE_RELEASE_DATE = "MovieReleaseDate"
        const val EXTRA_POSTER_PATH = "MoviePosterPath"
        const val EXTRA_VOTE_AVERAGE = "MovieVoteAverage"
        const val EXTRA_GENRES = "MovieGenres"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_details)
        println("Genres:" + intent.getStringExtra(EXTRA_MOVIE_TITLE))
        // Get the Intent that started this activity and extract the string
        tvMovieTitleDetails.text = intent.getStringExtra(EXTRA_MOVIE_TITLE)
        tvMoviOverview.text = intent.getStringExtra(EXTRA_MOVIE_OVERVIEW)
        tvMovieReleaseDate.text = intent.getStringExtra(EXTRA_MOVIE_RELEASE_DATE)
        tvMovieVoteAverage.text = intent.getStringExtra(EXTRA_VOTE_AVERAGE)
        tvMovieGenres.text = intent.getStringExtra(EXTRA_GENRES)
        Picasso.with(baseContext)
                .load("https://image.tmdb.org/t/p/w640/"+intent.getStringExtra(EXTRA_POSTER_PATH))
                .resize(250, 250)
                .into(ivPosterPath)
    }

    override fun context(): Context {
        return  this
    }

}