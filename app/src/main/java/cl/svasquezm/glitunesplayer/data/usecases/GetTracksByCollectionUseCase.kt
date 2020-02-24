package cl.svasquezm.glitunesplayer.data.usecases

import cl.svasquezm.glitunesplayer.domain.repositories.TrackRepository

class GetTracksByCollectionUseCase(private val repo: TrackRepository){
    fun execute(collectionId: Long) = repo.findAllTracksByCollection(collectionId)
}
