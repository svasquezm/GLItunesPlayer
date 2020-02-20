package cl.svasquezm.glitunesplayer.domain

/**
 * Track Domain representation.
 */
class TrackDomainModel(
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
