package cl.svasquezm.glitunesplayer.domain.repositories

import androidx.paging.DataSource
import cl.svasquezm.glitunesplayer.domain.models.TrackDomainModel

interface TrackRepository {
    suspend fun findAllTracks(): DataSource.Factory<Int, TrackDomainModel>
    fun findTrackById(id: Long): TrackDomainModel
    fun findAllTracks(term: String): List<TrackDomainModel>
    fun findAllTracksByCollection(collectionId: Long): List<TrackDomainModel>
    fun insert(tracks: List<TrackDomainModel>)
}