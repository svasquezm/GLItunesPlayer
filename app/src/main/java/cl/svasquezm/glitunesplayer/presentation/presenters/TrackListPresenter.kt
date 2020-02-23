package cl.svasquezm.glitunesplayer.presentation.presenters

import android.view.ViewGroup
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cl.svasquezm.glitunesplayer.domain.models.TrackDomainModel
import cl.svasquezm.glitunesplayer.presentation.adapters.TrackListAdapter
import cl.svasquezm.glitunesplayer.presentation.adapters.diffcallbacks.TrackDiffCallback

class TrackListPresenter(parentView: ViewGroup) {

    private val tracksAdapter by lazy { TrackListAdapter(TrackDiffCallback()) }
    val recyclerView by lazy {
        RecyclerView(parentView.context).apply {
            layoutManager = LinearLayoutManager(parentView.context)
            adapter = tracksAdapter
        }
    }

    fun updateView(pagedList: PagedList<TrackDomainModel>){
        tracksAdapter.submitList(pagedList)
        tracksAdapter.notifyDataSetChanged()
    }
}