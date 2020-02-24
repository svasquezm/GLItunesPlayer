package cl.svasquezm.glitunesplayer.domain.repositories

import androidx.paging.DataSource
import cl.svasquezm.glitunesplayer.domain.models.TrackDomainModel

interface TrackRepository {
    suspend fun findAllTracks(): DataSource.Factory<Int, TrackDomainModel>
    fun findAllTracks(term: String): List<TrackDomainModel>
    suspend fun findAllTracksByCollection(collectionId: Long): DataSource.Factory<Int, TrackDomainModel>
    fun insert(tracks: List<TrackDomainModel>)
}