package development.alberto.com.trakttvtest.data.model.trakt


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by alber on 07/09/2017.
 */
class Trakt {

    @SerializedName("watchers")
    @Expose
    var watchers: Int? = null
    @SerializedName("movie")
    @Expose
    var movie: Movie? = null

}