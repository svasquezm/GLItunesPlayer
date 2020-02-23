package cl.svasquezm.glitunesplayer.data.repositories

import androidx.paging.DataSource
import cl.svasquezm.glitunesplayer.data.databases.TrackRoomDatabase
import cl.svasquezm.glitunesplayer.domain.models.TrackDomainModel
import cl.svasquezm.glitunesplayer.domain.repositories.TrackRepository

class DefaultTrackRepository(private val db: TrackRoomDatabase) : TrackRepository {
    override suspend fun findAllTracks()
            = db.dao().findAllTracks()

    override suspend fun findAllTracks(term: String)
            = db.dao().findAllTracksByTerm(term)

    override suspend fun findAllTracksByCollection(collectionId: Long)
            = db.dao().findTracksForCollection(collectionId)

    override fun insert(tracks: List<TrackDomainModel>) =
        db.dao().insert(tracks)
}
