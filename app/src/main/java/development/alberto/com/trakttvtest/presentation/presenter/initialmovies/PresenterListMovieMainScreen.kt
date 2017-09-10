package development.alberto.com.trakttvtest.presentation.presenter.initialmovies

import development.alberto.com.trakttvtest.data.model.realmobject.ImageMovieDetails
import development.alberto.com.trakttvtest.domain.interactor.Interactor
import development.alberto.com.trakttvtest.presentation.presenter.Presenter
import development.alberto.com.trakttvtest.presentation.view.initialmovies.ViewActivity

/**
 * Created by alber on 09/09/2017.
 */


class PresenterListMovieMainScreen(var viewActivity: ViewActivity) : Presenter {

    lateinit var interactorTraktListImages:Interactor
    var listImageMoviesDetailsCached : List<ImageMovieDetails>? = null

    override fun onCreate() {
        //Call to check the service...
        interactorTraktListImages = Interactor()
        listImageMoviesDetailsCached = interactorTraktListImages.getObservableListImageMoviesDetailsCached()
        viewActivity.showMovieListInView(listImageMoviesDetailsCached!!)
    }

    override fun onResume() {

    }

    override fun onPause() {

    }

    override fun onDestroy() {
    }

}