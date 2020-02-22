package cl.svasquezm.glitunesplayer.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import cl.svasquezm.glitunesplayer.R
import cl.svasquezm.glitunesplayer.domain.models.TrackDomainModel
import cl.svasquezm.glitunesplayer.presentation.adapters.viewholders.TrackViewHolder

class TrackListAdapter(diffCallback: DiffUtil.ItemCallback<TrackDomainModel>) : PagedListAdapter<TrackDomainModel, TrackViewHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        TrackViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item_track, parent, false))

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }
}
