package cl.svasquezm.glitunesplayer.data.usecases

import cl.svasquezm.glitunesplayer.domain.repositories.SearchQueryRepository

class GetSearchQueriesUseCase(private val repo: SearchQueryRepository){
    suspend fun execute() = repo.findAllQueries()
}