package development.alberto.com.trakttvtest.data.service

import development.alberto.com.trakttvtest.data.api.TmdbtApi
import development.alberto.com.trakttvtest.data.api.TraktApi
import development.alberto.com.trakttvtest.data.constants.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by alber on 07/09/2017.
 */

class RetrofitService {

    fun restApiServiceTrakt(): TraktApi {
        var retrofit: Retrofit? = Retrofit.Builder()
                .baseUrl(Constants.TRAKT_URL_BASE)
                .client(OkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit!!.create(TraktApi::class.java)

    }

    fun restApiServiceTmdb(): TmdbtApi {
        var retrofit: Retrofit? = Retrofit.Builder()
                .baseUrl(Constants.URL_BASE_TMDB)
                .client(OkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit!!.create(TmdbtApi::class.java)

    }
}