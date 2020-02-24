package cl.svasquezm.glitunesplayer.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.svasquezm.glitunesplayer.data.usecases.GetNetworkTracksByCollectionUseCase
import cl.svasquezm.glitunesplayer.data.usecases.GetTrackByIdUseCase
import cl.svasquezm.glitunesplayer.data.usecases.GetTracksByCollectionUseCase
import cl.svasquezm.glitunesplayer.domain.models.TrackDomainModel
import kotlinx.coroutines.launch

class CollectionDetailsViewModel(private val getTrackByIdUseCase: GetTrackByIdUseCase,
                                 private val getTracksByCollectionUseCase: GetTracksByCollectionUseCase,
                                 private val getNetworkTracksByCollectionUseCase: GetNetworkTracksByCollectionUseCase
) :
    ViewModel() {
    var collectionTracksLiveData: MutableLiveData<List<TrackDomainModel>> = MutableLiveData()

    fun getTrackByIdUseCase(trackId: Long) = getTrackByIdUseCase.execute(trackId)
    fun getCollectionTracks(collectionId: Long) {
        viewModelScope.launch {
            getNetworkTracksByCollectionUseCase.execute(collectionId){
                collectionTracksLiveData.value = getTracksByCollectionUseCase.execute(collectionId)
            }
        }
    }
}
