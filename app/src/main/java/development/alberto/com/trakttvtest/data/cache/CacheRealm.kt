package development.alberto.com.trakttvtest.data.cache

import development.alberto.com.trakttvtest.data.model.realmobject.ImageMovieDetails
import io.reactivex.Observable
import io.realm.Realm

/**
 * Created by alber on 09/09/2017.
 */

class  CacheRealm {

    companion object {
        fun putTmdbToRealmCacheImageMovie(imageMovieDetails: ImageMovieDetails){
            val realm = Realm.getDefaultInstance()
            realm.beginTransaction()
            realm.copyToRealmOrUpdate(imageMovieDetails)
            println("Ids of ImageMovieDetails: "+imageMovieDetails.id)
            realm.commitTransaction()
            realm.close()
        }
        fun getImageMoviesDetails(): Observable<List<ImageMovieDetails>>? {
            val realm = Realm.getDefaultInstance()
            var imageMoviesDetails : List<ImageMovieDetails> = ArrayList( realm.where(ImageMovieDetails::class.java).findAll())
            println("Cache of ImageMovieDetails size: "+imageMoviesDetails.size)
            return Observable.just(imageMoviesDetails)
        }
    }
}