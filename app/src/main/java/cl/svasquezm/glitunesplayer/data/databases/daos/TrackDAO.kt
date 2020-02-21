package cl.svasquezm.glitunesplayer.data.databases.daos

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Query
import cl.svasquezm.glitunesplayer.data.utils.RoomNames
import cl.svasquezm.glitunesplayer.domain.models.TrackDomainModel

@Dao
interface TrackDAO {
    @Query("select * from ${RoomNames.TrackName} where name like '%' || :term || '%'")
    fun findAllTracksByTerm(term: String): DataSource.Factory<Int, TrackDomainModel>

    @Query("select * from ${RoomNames.TrackName} where collectionId = ':collectionId'")
    fun findTracksForCollection(collectionId: String): DataSource.Factory<Int, TrackDomainModel>
}
