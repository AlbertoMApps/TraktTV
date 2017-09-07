package development.alberto.com.trakttvtest.data.api

import development.alberto.com.trakttvtest.data.constants.Constants
import development.alberto.com.trakttvtest.data.model.trakt.Trakt
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers

/**
 * Created by alber on 07/09/2017.
 */

interface TraktApi {
    @Headers(
            Constants.HEADER_CONTENT_TYPE + ":" + Constants.TRAKT_CONTENT_TYPE,
            Constants.HEADER_API_VERSION + ": " + Constants.TRAKT_API_VERSION,
            Constants.HEADER_API_KEY + ": " + Constants.TRAKT_API_KEY)

    @GET
    (Constants.TRAKT)

    fun getTraktDataObservable(): Observable<List<Trakt>>

}
