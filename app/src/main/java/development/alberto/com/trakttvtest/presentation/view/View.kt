package development.alberto.com.trakttvtest.presentation.view

import android.content.Context
import development.alberto.com.trakttvtest.data.model.realmobject.ImageMovieDetails

/**
 * Created by alber on 09/09/2017.
 */
interface View {
    fun context(): Context
    fun showMovieListInView(imageMovieDetails:List<ImageMovieDetails>)
}