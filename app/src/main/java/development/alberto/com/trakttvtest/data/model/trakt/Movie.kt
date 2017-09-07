package development.alberto.com.trakttvtest.data.model.trakt

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by alber on 07/09/2017.
 */

 class Movie {

    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("year")
    @Expose
    var year : Int? = null
    @SerializedName("ids")
    @Expose
    var ids:Ids? = null;

}