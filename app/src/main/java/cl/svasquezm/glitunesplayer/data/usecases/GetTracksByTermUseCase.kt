package cl.svasquezm.glitunesplayer.data.usecases

import cl.svasquezm.glitunesplayer.domain.models.TrackDomainModel
import cl.svasquezm.glitunesplayer.domain.repositories.TrackRepository

class GetTracksByTermUseCase(private val repo: TrackRepository){
    fun execute(term: String = ""): List<TrackDomainModel> {
        val tracks = repo.findAllTracks(term)
        return tracks
    }

}
