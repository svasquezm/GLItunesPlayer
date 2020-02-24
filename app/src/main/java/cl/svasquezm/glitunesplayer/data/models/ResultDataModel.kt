package cl.svasquezm.glitunesplayer.data.models

import com.google.gson.annotations.SerializedName

class ResultDataModel(
    @SerializedName("trackId")
    val id: Long,

    @SerializedName("trackName")
    val name: String,

    @SerializedName("collectionId")
    val collectionId: Long,

    @SerializedName("collectionName")
    val collectionName: String,

    @SerializedName("artworkUrl100")
    val artWorkUrl: String,

    @SerializedName("previewUrl")
    val previewUrl: String,

    @SerializedName("artistName")
    val artistName: String,

    @SerializedName("trackNumber")
    val trackNumber: Int,

    @SerializedName("trackTimeMillis")
    val time: Long,

    @SerializedName("isStreamable")
    val isStreamable: Boolean = false,

    @SerializedName("kind")
    val kind: String
)