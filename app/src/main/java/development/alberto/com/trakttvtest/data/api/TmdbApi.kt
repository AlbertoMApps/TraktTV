package development.alberto.com.trakttvtest.data.api

import development.alberto.com.trakttvtest.data.constants.Constants
import development.alberto.com.trakttvtest.data.model.tmdb.Tmdb
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by alber on 07/09/2017.
 */

interface TmdbApi {
    @GET
    (Constants.TMDB_DETAIL)
    fun getTMDBDataObservable(@Path("id") tag: Int, @Query("api_key") apiKey: String): Observable<Tmdb>
}