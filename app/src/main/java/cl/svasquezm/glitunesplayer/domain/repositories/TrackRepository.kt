package cl.svasquezm.glitunesplayer.domain.repositories

import androidx.paging.DataSource
import cl.svasquezm.glitunesplayer.domain.models.TrackDomainModel

interface TrackRepository {
    fun findAllTracks(term: String): DataSource.Factory<Int, TrackDomainModel>
    fun findAllTracksByCollection(collectionId: String): DataSource.Factory<Int, TrackDomainModel>
}