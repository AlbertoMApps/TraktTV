package development.alberto.com.trakttvtest.domain.interactor

import development.alberto.com.trakttvtest.data.datarepository.DataTraktTmdbRepository
import development.alberto.com.trakttvtest.data.model.realmobject.ImageMovieDetails
import development.alberto.com.trakttvtest.domain.domainrepository.CallDataTraktTmdbRepository

/**
 * Created by alber on 09/09/2017.
 */

class Interactor {

    var call:CallDataTraktTmdbRepository = DataTraktTmdbRepository()

    //here we will make th call to the API to mix them and cahe the result of it
    fun getObservableListImageMoviesDetailsCached(): List<ImageMovieDetails>? {
        call.getDataRepositoryMerged()
        return call.listImageMoviesDetailsCached()
    }

}