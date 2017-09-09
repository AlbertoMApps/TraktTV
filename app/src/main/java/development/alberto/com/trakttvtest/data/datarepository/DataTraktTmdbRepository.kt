package development.alberto.com.trakttvtest.data.datarepository

import development.alberto.com.trakttvtest.data.api.TmdbtApi
import development.alberto.com.trakttvtest.data.api.TraktApi
import development.alberto.com.trakttvtest.data.cache.CacheRealm
import development.alberto.com.trakttvtest.data.constants.Constants
import development.alberto.com.trakttvtest.data.model.mapper.TmdbMapperToRealmImageMovieDetails
import development.alberto.com.trakttvtest.data.model.realmobject.ImageMovieDetails
import development.alberto.com.trakttvtest.data.model.tmdb.Tmdb
import development.alberto.com.trakttvtest.data.service.RetrofitService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executors


/**
 * Created by alber on 07/09/2017.
 */

class DataTraktTmdbRepository() {

    var retrofitService:RetrofitService = RetrofitService()
    var apiServiceTrakt: TraktApi = retrofitService.restApiServiceTrakt()
    var apiServiceTmdb:TmdbtApi = retrofitService.restApiServiceTmdb()

//Mix of Apis in order to make one main one to pass to caching and rest of the app....
    fun getDataRepositoryMerged() {

        var observableTmdb:Observable<Tmdb>
        val do1 = object : DisposableObserver<Tmdb>() {
            override fun onComplete() {
                println("finished y ole!")
            }

            override fun onNext(tmdb: Tmdb) {
                println(tmdb.title)
                println(tmdb.posterPath)
                println(tmdb.overview)
                println(tmdb.releaseDate)
                CacheRealm.putTmdbToRealmCacheImageMovie( TmdbMapperToRealmImageMovieDetails.mapTmdbToRealmImageMovieDetails(tmdb) )
            }

            override fun onError(e: Throwable) {
                println(e.message)
            }
        }

            apiServiceTrakt.getTraktDataObservable()
                    .flatMapIterable{t->t}
                    .flatMap { tmdb-> apiServiceTmdb.getTMDBDataObservable(tmdb.movie!!.ids!!.tmdb!!, Constants.TMDB_API_KEY) }
                    .subscribeOn(Schedulers.io())
                    .observeOn( Schedulers.from(Executors.newCachedThreadPool()))
                    .unsubscribeOn(AndroidSchedulers.mainThread())
                    .subscribe(do1)

        }

    //Retrieving the realm objects ImageMovieDetails from the cache DAO
    fun observableListImageMoviesDetailsCached(): Observable<List<ImageMovieDetails>>? {
        return CacheRealm.getImageMoviesDetails()
    }

}


