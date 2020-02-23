package cl.svasquezm.glitunesplayer.data.usecases

import cl.svasquezm.glitunesplayer.domain.models.SearchQueryModel
import cl.svasquezm.glitunesplayer.domain.models.TrackDomainModel
import cl.svasquezm.glitunesplayer.domain.repositories.SearchQueryRepository
import cl.svasquezm.glitunesplayer.domain.repositories.TrackRepository

class InsertSearchQueryUseCase(private val repo: SearchQueryRepository){
    fun execute(query: SearchQueryModel) = repo.insert(query)
}
