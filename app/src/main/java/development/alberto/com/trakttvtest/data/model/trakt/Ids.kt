package development.alberto.com.trakttvtest.data.model.trakt

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by alber on 07/09/2017.
 */

class Ids {

    @SerializedName("trakt")
    @Expose
    var trakt: Int? = null
    @SerializedName("slug")
    @Expose
    var slug: String? = null
    @SerializedName("imdb")
    @Expose
    var imdb: String? = null
    @SerializedName("tmdb")
    @Expose
    var tmdb: Int? = null

}