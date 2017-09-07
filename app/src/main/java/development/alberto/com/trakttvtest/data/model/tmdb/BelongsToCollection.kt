package development.alberto.com.trakttvtest.data.model.tmdb

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by alber on 07/09/2017.
 */
class BelongsToCollection {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("poster_path")
    @Expose
    var posterPath: String? = null
    @SerializedName("backdrop_path")
    @Expose
    var backdropPath: String? = null

}