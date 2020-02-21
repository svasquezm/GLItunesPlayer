package cl.svasquezm.glitunesplayer.data.repositories

import cl.svasquezm.glitunesplayer.data.databases.TrackRoomDatabase
import cl.svasquezm.glitunesplayer.domain.repositories.TrackRepository

class DefaultTrackRepository(private val db: TrackRoomDatabase) : TrackRepository {
    override suspend fun findAllTracks(term: String)
            = db.dao().findAllTracksByTerm(term)

    override suspend fun findAllTracksByCollection(collectionId: Long)
            = db.dao().findTracksForCollection(collectionId)
}
