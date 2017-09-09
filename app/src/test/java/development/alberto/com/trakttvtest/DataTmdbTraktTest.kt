package development.alberto.com.trakttvtest

import development.alberto.com.trakttvtest.data.api.TmdbApi
import development.alberto.com.trakttvtest.data.api.TraktApi
import development.alberto.com.trakttvtest.data.constants.Constants
import development.alberto.com.trakttvtest.data.model.tmdb.Tmdb
import development.alberto.com.trakttvtest.data.model.trakt.Trakt
import development.alberto.com.trakttvtest.data.service.RetrofitService
import io.reactivex.Observable
import io.reactivex.functions.Consumer
import io.reactivex.observers.TestObserver
import org.junit.Assert
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CloudStoreTest {

    @Mock
    lateinit var restApiTrakt:TraktApi
    @Mock
    lateinit var restApiTmdb: TmdbApi
    var retrofitService:RetrofitService = RetrofitService()
    val traktObserver: TestObserver<List<Trakt>> = TestObserver()
    val tmdbObserver: TestObserver<Tmdb> = TestObserver()

    @Before
    fun setup(){
        restApiTrakt = retrofitService.restApiServiceTrakt()
        restApiTmdb = retrofitService.restApiServiceTmdb()
    }

    @Test
    fun testPerformTraktRestService(){
        var traktObservable: Observable<List<Trakt>> = restApiTrakt.getTraktDataObservable()

        traktObservable.subscribeWith(traktObserver)
        traktObservable.subscribe(Consumer { data -> assertNotNull(data) })
        traktObservable.subscribe(Consumer {data -> Assert.assertEquals(20,data.size)})
        traktObservable.subscribe(Consumer {data -> Assert.assertFalse(data.size<0) })
        traktObserver.assertNoErrors()
        traktObserver.assertComplete()
        traktObserver.assertNoTimeout()

    }

    @Test
    fun testGetDataRepositoryMerged(){
        var mergedObservable: Observable<Tmdb> = restApiTrakt.getTraktDataObservable()
                .flatMapIterable{t->t}
                .flatMap { tmdb-> restApiTmdb.getTMDBDataObservable(tmdb.movie!!.ids!!.tmdb!!, Constants.TMDB_API_KEY) }

        mergedObservable.subscribeWith(tmdbObserver)
        mergedObservable.subscribe(Consumer { data -> assertNotNull(data) })
        tmdbObserver.assertNoErrors()
        tmdbObserver.assertComplete()
        tmdbObserver.assertNoTimeout()

    }


}
