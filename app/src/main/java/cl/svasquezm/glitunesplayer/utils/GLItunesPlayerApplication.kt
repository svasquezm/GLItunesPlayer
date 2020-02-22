package cl.svasquezm.glitunesplayer.utils

import android.app.Application
import androidx.room.Room
import cl.svasquezm.glitunesplayer.data.databases.TrackRoomDatabase
import cl.svasquezm.glitunesplayer.data.repositories.DefaultTrackRepository
import cl.svasquezm.glitunesplayer.data.usecases.GetTracksByTermUseCase
import cl.svasquezm.glitunesplayer.data.utils.RoomNames
import cl.svasquezm.glitunesplayer.domain.repositories.TrackRepository

class GLItunesPlayerApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        /*
         * Dependencies for project (alternative for dependency injection)
         */
        val db = Room.databaseBuilder(
            applicationContext,
            TrackRoomDatabase::class.java,
            RoomNames.trackDatabaseName
        ).allowMainThreadQueries().build()

        val trackRepository: TrackRepository = DefaultTrackRepository(db)
        val getTracksByTermUseCase = GetTracksByTermUseCase(trackRepository)
    }

    object Dependencies {
        lateinit var db: TrackRoomDatabase
        lateinit var trackRepository: TrackRepository
        lateinit var getTracksByTermUseCase: GetTracksByTermUseCase
    }
}