package cl.svasquezm.glitunesplayer.data.networking

import cl.svasquezm.glitunesplayer.data.models.ResultsModel
import cl.svasquezm.glitunesplayer.utils.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TracksRetrofitService {

    @GET("search")
    fun getTracks(
        @Query("term") term: String,
        @Query("page") page: Int,
        @Query("limit") limit: Int = Constants.PAGE_SIZE,
        @Query("mediaType") mediaType: String = "music"): Call<ResultsModel>

    @GET("lookup")
    fun getCollectionTracks(
        @Query("id") id: Long,
        @Query("entity") page: String = "song"): Call<ResultsModel>
}