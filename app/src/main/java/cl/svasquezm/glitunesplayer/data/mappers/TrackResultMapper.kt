package cl.svasquezm.glitunesplayer.data.mappers

import cl.svasquezm.glitunesplayer.data.models.ResultDataModel
import cl.svasquezm.glitunesplayer.domain.models.TrackDomainModel

class TrackResultMapper {
    fun map(list: List<ResultDataModel>) = list.map {
        TrackDomainModel(
            id = it.id,
            name = it.name,
            collectionId = it.collectionId,
            collectionName = it.collectionName,
            artWorkUrl = it.artWorkUrl,
            previewUrl = it.previewUrl,
            artistName = it.artistName,
            trackNumber = it.trackNumber,
            isStreamable = it.isStreamable
        )
    }
}
