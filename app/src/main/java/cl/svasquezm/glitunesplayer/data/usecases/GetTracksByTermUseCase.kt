package cl.svasquezm.glitunesplayer.data.usecases

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import cl.svasquezm.glitunesplayer.domain.models.TrackDomainModel
import cl.svasquezm.glitunesplayer.domain.repositories.TrackRepository
import cl.svasquezm.glitunesplayer.utils.Constants

class GetTracksByTermUseCase(private val repo: TrackRepository){
    suspend fun execute(term: String = ""): LiveData<PagedList<TrackDomainModel>> {
        val config = PagedList.Config.Builder()
            .setInitialLoadSizeHint(Constants.PAGE_SIZE)
            .setPageSize(Constants.PAGE_SIZE)
            .build()

        return LivePagedListBuilder<Int, TrackDomainModel>(repo.findAllTracks(term), config).build()
    }
}
