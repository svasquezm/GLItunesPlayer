package cl.svasquezm.glitunesplayer.domain.repositories

import androidx.paging.DataSource
import cl.svasquezm.glitunesplayer.domain.models.TrackDomainModel

interface TrackRepository {
    fun findAllTracks(term: String): DataSource<Int, TrackDomainModel>
    fun findAllTracksByCollection(collectionId: String): DataSource<Int, TrackDomainModel>
}