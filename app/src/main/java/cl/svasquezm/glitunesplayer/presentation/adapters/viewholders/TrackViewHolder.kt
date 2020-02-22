package cl.svasquezm.glitunesplayer.presentation.adapters.viewholders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cl.svasquezm.glitunesplayer.R
import cl.svasquezm.glitunesplayer.domain.models.TrackDomainModel

class TrackViewHolder(view: View) : RecyclerView.ViewHolder(view){
    private val trackName = view.findViewById<TextView>(R.id.name)
    private val artistName = view.findViewById<TextView>(R.id.artist)
    private val albumName = view.findViewById<TextView>(R.id.album)

    fun bind(track: TrackDomainModel){
        trackName.text = track.name
        artistName.text = track.artistName
        albumName.text = track.collectionName
    }
}