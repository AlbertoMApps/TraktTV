package development.alberto.com.trakttvtest.data.service

import development.alberto.com.trakttvtest.data.api.TmdbApi
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

    var retrofit: Retrofit? = null

    fun restService(urlBase:String) {
        retrofit = Retrofit.Builder()
                .baseUrl(urlBase)
                .client(OkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun restCreateApiServiceTrakt() : TraktApi {
        return retrofit!!.create(TraktApi::class.java)

    }
    fun restCreateApiServiceTmdb() : TmdbApi {
        return retrofit!!.create(TmdbApi::class.java)

    }
}