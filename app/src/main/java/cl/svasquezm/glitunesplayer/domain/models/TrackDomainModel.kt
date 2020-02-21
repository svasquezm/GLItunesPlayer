package cl.svasquezm.glitunesplayer.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import cl.svasquezm.glitunesplayer.data.utils.RoomNames

/**
 * Track Domain representation.
 */
@Entity(tableName = RoomNames.tracks)
class TrackDomainModel(
    @PrimaryKey
    val id: Long,
    val name: String,
    val collectionId: Long,
    val collectionName: String,
    val artWorkUrl: String,
    val artistName: String,
    val trackNumber: Int,
    val time: Long,
    val isStreamable: Boolean
)
