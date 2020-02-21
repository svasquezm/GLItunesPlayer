package cl.svasquezm.glitunesplayer.data.repositories

import cl.svasquezm.glitunesplayer.data.databases.TrackRoomDatabase
import cl.svasquezm.glitunesplayer.domain.repositories.TrackRepository

class DefaultTrackRepository(private val db: TrackRoomDatabase) : TrackRepository {
    override fun findAllTracks(term: String) = db.dao().findAllTracksByTerm(term)
    override fun findAllTracksByCollection(collectionId: String) = db.dao().findTracksForCollection(collectionId)
}
