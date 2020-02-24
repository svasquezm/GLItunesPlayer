package cl.svasquezm.glitunesplayer.data.usecases

import cl.svasquezm.glitunesplayer.domain.repositories.TrackRepository

class GetTrackByIdUseCase(private val repo: TrackRepository){
    fun execute(id: Long) = repo.findTrackById(id)
}
