package cl.svasquezm.glitunesplayer.presentation.presenters

import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cl.svasquezm.glitunesplayer.domain.models.TrackDomainModel
import cl.svasquezm.glitunesplayer.presentation.adapters.TrackListAdapter

class TrackListPresenter(parentView: ViewGroup) {

    private val tracksAdapter by lazy { TrackListAdapter(listOf()) }
    val recyclerView by lazy {
        RecyclerView(parentView.context).apply {
            layoutManager = LinearLayoutManager(parentView.context)
            adapter = tracksAdapter
        }
    }

    fun updateView(list: List<TrackDomainModel>){
        tracksAdapter.tracks = list
        tracksAdapter.notifyDataSetChanged()
    }

    fun setOnTrackClickListener(listener: (TrackDomainModel) -> Unit){
        tracksAdapter.onItemClickListener = listener
    }
}