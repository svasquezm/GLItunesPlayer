package cl.svasquezm.glitunesplayer.utils

import android.media.AudioAttributes
import android.media.MediaPlayer
import kotlinx.coroutines.*

class PlayMediaHelper {
    private var currentMediaUrl: String? = null
    private var mediaPlayer: MediaPlayer? = null

    suspend fun playOrStopMedia(mediaUrl: String?) {
        mediaUrl?.let {
            if (currentMediaUrl == mediaUrl) {

                // Remove previous url
                currentMediaUrl = ""
                stopCurrentMedia()
            } else {
                currentMediaUrl = mediaUrl
                playCurrentMedia()
            }
        }
    }

    /**
     * Plays current media stopping last process
     */
    suspend fun playCurrentMedia() =
        withContext(Dispatchers.IO) {
            if (mediaPlayer != null) {
                stopCurrentMedia()
            }

            mediaPlayer = MediaPlayer().apply {
                setAudioAttributes(
                    AudioAttributes.Builder()
                        .setFlags(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .build()
                )
                setDataSource(currentMediaUrl)
                prepare()
                start()
            }

        }

    private fun stopCurrentMedia() {
        mediaPlayer?.stop()
    }
}
