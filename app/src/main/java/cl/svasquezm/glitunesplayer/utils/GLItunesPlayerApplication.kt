package cl.svasquezm.glitunesplayer.utils

import android.app.Application
import androidx.room.Room
import cl.svasquezm.glitunesplayer.data.databases.TrackRoomDatabase
import cl.svasquezm.glitunesplayer.data.networking.TracksRetrofitService
import cl.svasquezm.glitunesplayer.data.repositories.DefaultSearchQueryRepository
import cl.svasquezm.glitunesplayer.data.repositories.DefaultTrackRepository
import cl.svasquezm.glitunesplayer.data.usecases.GetSearchQueriesUseCase
import cl.svasquezm.glitunesplayer.data.usecases.GetTracksByTermUseCase
import cl.svasquezm.glitunesplayer.data.usecases.InsertSearchQueryUseCase
import cl.svasquezm.glitunesplayer.data.usecases.InsertTracksUseCase
import cl.svasquezm.glitunesplayer.data.utils.RoomNames
import cl.svasquezm.glitunesplayer.domain.models.SearchQueryModel
import cl.svasquezm.glitunesplayer.domain.repositories.SearchQueryRepository
import cl.svasquezm.glitunesplayer.domain.repositories.TrackRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GLItunesPlayerApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        /*
         * Dependencies for project (alternative for dependency injection)
         */
        Dependencies.db = Room.databaseBuilder(
            applicationContext,
            TrackRoomDatabase::class.java,
            RoomNames.trackDatabaseName
        ).allowMainThreadQueries().build()

        Dependencies.initDependencies()
    }

    object Dependencies {
        lateinit var db: TrackRoomDatabase
        lateinit var trackRepository: TrackRepository
        lateinit var searchQueryRepository: SearchQueryRepository
        lateinit var getSearchQueriesUseCase: GetSearchQueriesUseCase
        lateinit var getTracksByTermUseCase: GetTracksByTermUseCase
        lateinit var insertTracksUseCase: InsertTracksUseCase
        lateinit var inserSearchQueryUseCase: InsertSearchQueryUseCase
        lateinit var retrofitService: TracksRetrofitService

        fun initDependencies(){
            retrofitService = Retrofit.Builder()
                .baseUrl("https://itunes.apple.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TracksRetrofitService::class.java)
            trackRepository = DefaultTrackRepository(db)
            searchQueryRepository = DefaultSearchQueryRepository(db)
            getSearchQueriesUseCase = GetSearchQueriesUseCase(searchQueryRepository)
            inserSearchQueryUseCase = InsertSearchQueryUseCase(searchQueryRepository)
            getTracksByTermUseCase = GetTracksByTermUseCase(trackRepository)
            insertTracksUseCase = InsertTracksUseCase(trackRepository)

            inserSearchQueryUseCase.execute(SearchQueryModel(1, "alasja"))
        }
    }
}
