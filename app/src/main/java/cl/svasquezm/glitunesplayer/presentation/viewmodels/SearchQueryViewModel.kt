package cl.svasquezm.glitunesplayer.presentation.viewmodels

import androidx.lifecycle.ViewModel
import cl.svasquezm.glitunesplayer.data.usecases.GetSearchQueriesUseCase

class SearchQueryViewModel(private val getSearchQueriesUseCase: GetSearchQueriesUseCase) : ViewModel() {
    fun getQueries() = getSearchQueriesUseCase.execute()
}
