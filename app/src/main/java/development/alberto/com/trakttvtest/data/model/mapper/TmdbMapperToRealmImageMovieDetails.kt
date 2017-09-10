package development.alberto.com.trakttvtest.data.model.mapper

import development.alberto.com.trakttvtest.data.model.realmobject.ImageMovieDetails
import development.alberto.com.trakttvtest.data.model.realmobject.RealmGenre
import development.alberto.com.trakttvtest.data.model.tmdb.Genre
import development.alberto.com.trakttvtest.data.model.tmdb.Tmdb
import io.realm.RealmList

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
                realmImageMovieDetails.voteAverage = tmdb.voteAverage
                realmImageMovieDetails.genres =  mapTmdbGenresToRealmGenres(tmdb.genres)
            }

            return realmImageMovieDetails
        }

        private fun mapTmdbGenresToRealmGenres(genres: List<Genre>?): RealmList<RealmGenre>? {
            var realmGenreList:RealmList<RealmGenre> = RealmList<RealmGenre>()

            if (genres!=null) {
                for( genre:Genre in genres ) {
                    realmGenreList.add(mapTmdbGenreToRealmGenre(genre))
                }
            }
            return realmGenreList
        }

        private fun mapTmdbGenreToRealmGenre(genre: Genre): RealmGenre? {
            var realmGenre:RealmGenre = RealmGenre()

            if (genre!=null) {
                realmGenre.id = genre.id
                realmGenre.name = genre.name
            }
            return realmGenre
        }
    }
}