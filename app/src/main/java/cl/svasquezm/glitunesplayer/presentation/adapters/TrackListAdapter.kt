package cl.svasquezm.glitunesplayer.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import cl.svasquezm.glitunesplayer.R
import cl.svasquezm.glitunesplayer.domain.models.TrackDomainModel
import cl.svasquezm.glitunesplayer.presentation.adapters.viewholders.TrackViewHolder

class TrackListAdapter(var tracks: List<TrackDomainModel>) : RecyclerView.Adapter<TrackViewHolder>() {
    override fun getItemCount() = tracks.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        TrackViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item_track, parent, false))

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        holder.bind(tracks[position])
    }
}
