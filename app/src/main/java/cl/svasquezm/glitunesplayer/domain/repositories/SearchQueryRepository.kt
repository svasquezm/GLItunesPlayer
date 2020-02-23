package cl.svasquezm.glitunesplayer.domain.repositories

import cl.svasquezm.glitunesplayer.domain.models.SearchQueryModel

interface SearchQueryRepository {
    fun findAllQueries(): List<SearchQueryModel>
}