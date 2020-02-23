package cl.svasquezm.glitunesplayer.data.models

import com.google.gson.annotations.SerializedName

class ResultsModel(
    @SerializedName("resultCount")
    val resultCount: Int,

    @SerializedName("results")
    val results: List<ResultDataModel>
)