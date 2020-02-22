package cl.svasquezm.glitunesplayer.presentation.adapters.diffcallbacks

import androidx.recyclerview.widget.DiffUtil
import cl.svasquezm.glitunesplayer.domain.models.TrackDomainModel

class TrackDiffCallback : DiffUtil.ItemCallback<TrackDomainModel>(){
    override fun areItemsTheSame(oldItem: TrackDomainModel, newItem: TrackDomainModel) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: TrackDomainModel, newItem: TrackDomainModel) = oldItem.id == newItem.id
}