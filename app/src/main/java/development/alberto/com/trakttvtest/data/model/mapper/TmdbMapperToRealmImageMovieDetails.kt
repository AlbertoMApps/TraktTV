package development.alberto.com.trakttvtest.data.model.mapper

import development.alberto.com.trakttvtest.data.model.realmobject.ImageMovieDetails
import development.alberto.com.trakttvtest.data.model.tmdb.Tmdb

/**
 * Created by alber on 09/09/2017.
 */

class  TmdbMapperToRealmImageMovieDetails {

    companion object {
        fun mapTmdbToRealmImageMovieDetails(tmdb: Tmdb): ImageMovieDetails {
            var realmImageMovieDetails:ImageMovieDetails = ImageMovieDetails()

            if( tmdb!=null) {
                realmImageMovieDetails.id = tmdb.id
                realmImageMovieDetails.title = tmdb.title
                realmImageMovieDetails.posterPath = tmdb.posterPath
                realmImageMovieDetails.overview = tmdb.overview
                realmImageMovieDetails.releaseDate = tmdb.releaseDate
            }

            return realmImageMovieDetails
        }
    }
}
