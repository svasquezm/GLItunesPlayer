package cl.svasquezm.glitunesplayer.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.svasquezm.glitunesplayer.data.usecases.GetNetworkTracksByTermUseCase
import cl.svasquezm.glitunesplayer.data.usecases.GetTracksByTermUseCase
import cl.svasquezm.glitunesplayer.domain.models.TrackDomainModel
import kotlinx.coroutines.launch

class TrackViewModel(private val getTracksByTermUseCase: GetTracksByTermUseCase,
                     private val getNetworkTracksByTermUseCase: GetNetworkTracksByTermUseCase
) : ViewModel() {
    var liveData: MutableLiveData<List<TrackDomainModel>> = MutableLiveData()

    fun getTracks(term: String = "", networking: Boolean = false){
        viewModelScope.launch {
            if(networking) {
                getNetworkTracksByTermUseCase.execute(term, onFinish = {
                    liveData.value = getTracksByTermUseCase.execute(term)
                })
            } else {
                liveData.value = getTracksByTermUseCase.execute(term)
            }
        }
    }
}
