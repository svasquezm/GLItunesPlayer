package cl.svasquezm.glitunesplayer.data.usecases

import cl.svasquezm.glitunesplayer.domain.models.TrackDomainModel
import cl.svasquezm.glitunesplayer.domain.repositories.TrackRepository

class InsertTracksUseCase(private val repo: TrackRepository){
    fun execute(list: List<TrackDomainModel>) = repo.insert(list)
}
