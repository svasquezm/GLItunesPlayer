package cl.svasquezm.glitunesplayer.data.databases.daos

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.svasquezm.glitunesplayer.data.utils.RoomNames
import cl.svasquezm.glitunesplayer.domain.models.SearchQueryModel
import cl.svasquezm.glitunesplayer.domain.models.TrackDomainModel

@Dao
interface TrackDAO {
    @Query("select * from ${RoomNames.tracks}")
    fun findAllTracks(): DataSource.Factory<Int, TrackDomainModel>

    @Query("select * from ${RoomNames.tracks} where name like '%' || :term || '%' or collectionName like '%' || :term || '%' or artistName like '%' || :term || '%'")
    fun findAllTracksByTerm(term: String): List<TrackDomainModel>

    @Query("select * from ${RoomNames.tracks} where collectionId = :collectionId")
    fun findTracksForCollection(collectionId: Long): DataSource.Factory<Int, TrackDomainModel>

    @Query("select * from ${RoomNames.searchQueries} order by id desc")
    fun findAllQueries(): List<SearchQueryModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(tracks: List<TrackDomainModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(query: SearchQueryModel)
}
