package cl.svasquezm.glitunesplayer.data.utils

import android.util.Log
import androidx.paging.PagedList
import cl.svasquezm.glitunesplayer.data.mappers.TrackResultMapper
import cl.svasquezm.glitunesplayer.data.models.ResultsModel
import cl.svasquezm.glitunesplayer.data.networking.TracksRetrofitService
import cl.svasquezm.glitunesplayer.data.usecases.InsertTracksUseCase
import cl.svasquezm.glitunesplayer.domain.models.TrackDomainModel
import cl.svasquezm.glitunesplayer.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TrackPagedListBoundaryCallback(
    private val retrofitService: TracksRetrofitService,
    private val insertTracksUseCase: InsertTracksUseCase,
    private val term: String = ""
) : PagedList.BoundaryCallback<TrackDomainModel>() {

    private var currentPage = 1
    private var totalPages = 1

    override fun onZeroItemsLoaded() {
        super.onZeroItemsLoaded()
        request()
    }

    override fun onItemAtEndLoaded(itemAtEnd: TrackDomainModel) {
        super.onItemAtEndLoaded(itemAtEnd)
        request()
    }

    private fun request() {
        if(currentPage <= totalPages) {
            retrofitService.getTracks(term = term, page = currentPage)
                .enqueue(object : Callback<ResultsModel> {
                    override fun onFailure(call: Call<ResultsModel>, t: Throwable) {
                        Log.i("RESPONSE", "Failed: $t")
                    }

                    override fun onResponse(
                        call: Call<ResultsModel>,
                        response: Response<ResultsModel>
                    ) {
                        if (!response.body()?.results.isNullOrEmpty()) {

                            // Remove non songs
                            response.body()?.let { results ->
                                results.results.filter { it.kind == "song" }.let {
                                    insertTracksUseCase.execute(TrackResultMapper().map(it))
                                }

                                // Recalculate total pages
                                totalPages = results.resultCount / Constants.PAGE_SIZE
                            }

                            currentPage++
                        }
                    }
                })
        }
    }
}
