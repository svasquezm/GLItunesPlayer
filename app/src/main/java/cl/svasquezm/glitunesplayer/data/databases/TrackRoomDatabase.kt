package cl.svasquezm.glitunesplayer.data.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import cl.svasquezm.glitunesplayer.data.databases.daos.TrackDAO
import cl.svasquezm.glitunesplayer.domain.models.SearchQueryModel
import cl.svasquezm.glitunesplayer.domain.models.TrackDomainModel

@Database(entities = [TrackDomainModel::class, SearchQueryModel::class], version = 1, exportSchema = false)
abstract class TrackRoomDatabase : RoomDatabase(){
    abstract fun dao(): TrackDAO
}
