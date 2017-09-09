package development.alberto.com.trakttvtest.data.model.realmobject

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by alber on 09/09/2017.
 */

open class ImageMovieDetails: RealmObject() {

    @PrimaryKey
    var id: Int? = null
    var title: String? = null
    var posterPath: String? = null
    var overview: String? = null
    var releaseDate: String? = null
}