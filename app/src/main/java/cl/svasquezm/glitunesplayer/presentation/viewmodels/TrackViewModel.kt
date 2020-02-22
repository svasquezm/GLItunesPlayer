package cl.svasquezm.glitunesplayer.presentation.viewmodels

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagedList
import cl.svasquezm.glitunesplayer.data.usecases.GetTracksByTermUseCase
import cl.svasquezm.glitunesplayer.domain.models.TrackDomainModel
import kotlinx.coroutines.launch

class TrackViewModel(private val getTracksByTermUseCase: GetTracksByTermUseCase) : ViewModel() {
    fun getTracks(observer: LifecycleOwner, term: String = "", onChange: (PagedList<TrackDomainModel>) -> Unit = {}){
        viewModelScope.launch {
            getTracksByTermUseCase.execute(term).observe(observer, Observer { onChange(it) })
        }
    }
}
