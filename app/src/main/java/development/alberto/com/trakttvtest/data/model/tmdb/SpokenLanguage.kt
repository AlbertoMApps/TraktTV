package development.alberto.com.trakttvtest.data.model.tmdb

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by alber on 07/09/2017.
 */

class SpokenLanguage {

    @SerializedName("iso_639_1")
    @Expose
    var iso6391: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null

}