package development.alberto.com.trakttvtest.presentation.presenter

import development.alberto.com.trakttvtest.data.model.realmobject.ImageMovieDetails
import development.alberto.com.trakttvtest.domain.interactor.Interactor
import development.alberto.com.trakttvtest.presentation.view.View

/**
 * Created by alber on 09/09/2017.
 */


class PresenterListMovieDetails( var view : View) : Presenter {

    lateinit var interactorTraktListImages:Interactor
    var listImageMoviesDetailsCached : List<ImageMovieDetails>? = null

    override fun onCreate() {
        //Call to check the service...
        interactorTraktListImages = Interactor()
        listImageMoviesDetailsCached = interactorTraktListImages.getObservableListImageMoviesDetailsCached()
        view.showMovieListInView(listImageMoviesDetailsCached!!)
    }

    override fun onResume() {

    }

    override fun onPause() {

    }

    override fun onDestroy() {

    }

}