package cl.svasquezm.glitunesplayer.data.utils

import androidx.paging.PagedList
import cl.svasquezm.glitunesplayer.data.usecases.GetNetworkTracksByTermUseCase
import cl.svasquezm.glitunesplayer.domain.models.TrackDomainModel

class TrackPagedListBoundaryCallback(private val getNetworkTracksByTermUseCase: GetNetworkTracksByTermUseCase) : PagedList.BoundaryCallback<TrackDomainModel>() {

    private var requesting = false
    private var currentPage = 0

    override fun onZeroItemsLoaded() {
        // First time? then request
        if(currentPage == 0){
            currentPage = 1
            request()
        }
    }

    override fun onItemAtEndLoaded(itemAtEnd: TrackDomainModel) {
        super.onItemAtEndLoaded(itemAtEnd)
        request()
    }

    /**
     * Perform a request for non empty query term param
     */
    private fun request() {
        if(!requesting) {
            requesting = true
            getNetworkTracksByTermUseCase.execute(page = currentPage) {
                requesting = false
            }
        }
    }
}
