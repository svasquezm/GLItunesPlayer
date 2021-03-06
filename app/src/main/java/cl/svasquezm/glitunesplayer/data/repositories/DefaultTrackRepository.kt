package cl.svasquezm.glitunesplayer.data.repositories

import cl.svasquezm.glitunesplayer.data.databases.TrackRoomDatabase
import cl.svasquezm.glitunesplayer.domain.models.TrackDomainModel
import cl.svasquezm.glitunesplayer.domain.repositories.TrackRepository

class DefaultTrackRepository(private val db: TrackRoomDatabase) : TrackRepository {
    override fun findAllTracksByCollection(collectionId: Long)
            = db.dao().findTracksForCollection(collectionId)

    override fun findTrackById(id: Long) = db.dao().findTrackById(id)

    override suspend fun findAllTracks()
            = db.dao().findAllTracks()

    override fun findAllTracks(term: String)
            = db.dao().findAllTracksByTerm(term)

    override fun insert(tracks: List<TrackDomainModel>) =
        db.dao().insert(tracks)
}
