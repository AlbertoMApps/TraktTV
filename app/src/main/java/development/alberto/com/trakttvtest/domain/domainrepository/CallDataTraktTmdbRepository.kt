package development.alberto.com.trakttvtest.domain.domainrepository

import development.alberto.com.trakttvtest.data.model.realmobject.ImageMovieDetails
import io.reactivex.Observable

/**
 * Created by alber on 09/09/2017.
 */

interface CallDataTraktTmdbRepository {
    fun getDataRepositoryMerged()
    fun listImageMoviesDetailsCached():List<ImageMovieDetails>?
}