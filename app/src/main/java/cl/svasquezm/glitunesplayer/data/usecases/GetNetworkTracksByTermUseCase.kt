package cl.svasquezm.glitunesplayer.data.usecases

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import cl.svasquezm.glitunesplayer.data.mappers.TrackResultMapper
import cl.svasquezm.glitunesplayer.data.models.ResultsModel
import cl.svasquezm.glitunesplayer.data.networking.TracksRetrofitService
import cl.svasquezm.glitunesplayer.domain.models.TrackDomainModel
import cl.svasquezm.glitunesplayer.domain.repositories.TrackRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetNetworkTracksByTermUseCase(
    private val retrofitService: TracksRetrofitService,
    private val repo: TrackRepository
) {
    fun execute(term: String = "", page: Int = 1, onFinish: () -> Unit = {}) {

        retrofitService.getTracks(term = term, page = page)
            .enqueue(object : Callback<ResultsModel> {
                override fun onFailure(call: Call<ResultsModel>, t: Throwable) {
                    Log.i("RESPONSE", "Failed: $t")
                    onFinish()
                }

                override fun onResponse(
                    call: Call<ResultsModel>,
                    response: Response<ResultsModel>
                ) {
                    if (!response.body()?.results.isNullOrEmpty()) {

                        // Remove non songs
                        response.body()?.let { results ->
                            results.results.filter { it.kind == "song" }.let {
                                repo.insert(TrackResultMapper().map(it))
                            }
                        }
                    }
                    onFinish()
                }
            })
    }
}
