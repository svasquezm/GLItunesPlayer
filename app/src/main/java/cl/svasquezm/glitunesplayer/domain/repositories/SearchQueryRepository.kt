package cl.svasquezm.glitunesplayer.domain.repositories

import androidx.lifecycle.LiveData
import cl.svasquezm.glitunesplayer.domain.models.SearchQueryModel

interface SearchQueryRepository {
    suspend fun findAllQueries(): LiveData<List<SearchQueryModel>>
}