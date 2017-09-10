package development.alberto.com.trakttvtest.data.model.realmobject

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by alber on 09/09/2017.
 */

open class RealmGenre : RealmObject() {

    @PrimaryKey
    var id: Int? = null
    var name: String? = null

}