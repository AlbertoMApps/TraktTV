package development.alberto.com.trakttvtest.data.datarepository

import development.alberto.com.trakttvtest.data.api.TmdbApi
import development.alberto.com.trakttvtest.data.api.TraktApi
import development.alberto.com.trakttvtest.data.cache.CacheRealm
import development.alberto.com.trakttvtest.data.constants.Constants
import development.alberto.com.trakttvtest.data.model.mapper.TmdbMapperToRealmImageMovieDetails
import development.alberto.com.trakttvtest.data.model.realmobject.ImageMovieDetails
import development.alberto.com.trakttvtest.data.service.RetrofitService
import development.alberto.com.trakttvtest.domain.domainrepository.CallDataTraktTmdbRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executors


/**
 * Created by alber on 07/09/2017.
 */

class DataTraktTmdbRepository(): CallDataTraktTmdbRepository {

    var retrofitService:RetrofitService = RetrofitService()
    lateinit var apiServiceTrakt: TraktApi
    lateinit var apiServiceTmdb: TmdbApi

//Mix of Apis in order to make one main one to pass to caching and rest of the app....
    override fun getDataRepositoryMerged() {
        //we call the retrofit in each api trakt and tmdb...
        retrofitService.restService(Constants.TRAKT_URL_BASE)
        apiServiceTrakt = retrofitService.restCreateApiServiceTrakt()
        retrofitService.restService(Constants.URL_BASE_TMDB)
        apiServiceTmdb = retrofitService.restCreateApiServiceTmdb()

            apiServiceTrakt.getTraktDataObservable()
                    .flatMapIterable{t->t}
                    .flatMap { trakt-> apiServiceTmdb.getTMDBDataObservable(trakt.movie!!.ids!!.tmdb!!, Constants.TMDB_API_KEY) }
                    .subscribeOn(Schedulers.io())
                    .observeOn( Schedulers.from(Executors.newCachedThreadPool()))
                    .unsubscribeOn(AndroidSchedulers.mainThread())
                    .subscribe(Consumer{ tmdb ->   CacheRealm.putTmdbToRealmCacheImageMovie( TmdbMapperToRealmImageMovieDetails.mapTmdbToRealmImageMovieDetails(tmdb) )},
                            Consumer { e -> println("Error: " + e.message )  })

        }

    //Retrieving the realm objects ImageMovieDetails from the cache DAO
    override fun listImageMoviesDetailsCached(): List<ImageMovieDetails>? {
        return CacheRealm.getImageMoviesDetails()
    }

}


