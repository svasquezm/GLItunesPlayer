package cl.svasquezm.glitunesplayer.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import cl.svasquezm.glitunesplayer.data.utils.RoomNames

/**
 * Search query stored.
 */
@Entity(tableName = RoomNames.searchQueries)
class SearchQueryModel(
    @PrimaryKey
    val id: Long,
    val query: String
)
