package cl.svasquezm.glitunesplayer.presentation.fragments

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cl.svasquezm.glitunesplayer.R
import cl.svasquezm.glitunesplayer.presentation.presenters.TrackListPresenter
import cl.svasquezm.glitunesplayer.presentation.viewmodels.TrackViewModel
import cl.svasquezm.glitunesplayer.utils.GLItunesPlayerApplication.Dependencies

@Suppress("UNCHECKED_CAST")
class TrackListFragment : Fragment() {
    lateinit var presenter: TrackListPresenter

    val viewModel by lazy {
        ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return TrackViewModel(
                    Dependencies.getTracksByTermUseCase,
                    Dependencies.insertTracksUseCase
                ) as T
            }
        }).get(TrackViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        container?.let {
            presenter = TrackListPresenter(container)
        }

        return presenter.recyclerView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getTracks(this)
        viewModel.mutableLiveData.observe(this, Observer {
            presenter.updateView(it)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.track_menu, menu)
    }
}
