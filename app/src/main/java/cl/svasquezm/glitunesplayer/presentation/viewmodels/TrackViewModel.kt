package cl.svasquezm.glitunesplayer.presentation.viewmodels

import androidx.lifecycle.*
import androidx.paging.PagedList
import cl.svasquezm.glitunesplayer.data.usecases.GetTracksByTermUseCase
import cl.svasquezm.glitunesplayer.data.usecases.InsertTracksUseCase
import cl.svasquezm.glitunesplayer.data.utils.TrackPagedListBoundaryCallback
import cl.svasquezm.glitunesplayer.domain.models.TrackDomainModel
import cl.svasquezm.glitunesplayer.utils.GLItunesPlayerApplication.Dependencies
import kotlinx.coroutines.launch

class TrackViewModel(private val getTracksByTermUseCase: GetTracksByTermUseCase,
                     private val insertTracksUseCase: InsertTracksUseCase
) : ViewModel() {
    var mutableLiveData: MutableLiveData<PagedList<TrackDomainModel>> = MutableLiveData()

    fun getTracks(observer: LifecycleOwner, term: String = "", onChange: (PagedList<TrackDomainModel>) -> Unit = {}){
        viewModelScope.launch {
            val list = getTracksByTermUseCase.execute(term,
                TrackPagedListBoundaryCallback(Dependencies.retrofitService,
                    insertTracksUseCase,
                    term)
            )

            list.observe(observer, Observer {
                mutableLiveData.value = it
            })
        }
    }
}
