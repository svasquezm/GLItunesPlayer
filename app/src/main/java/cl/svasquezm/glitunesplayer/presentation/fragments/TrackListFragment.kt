package cl.svasquezm.glitunesplayer.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cl.svasquezm.glitunesplayer.R
import cl.svasquezm.glitunesplayer.presentation.presenters.TrackListPresenter
import cl.svasquezm.glitunesplayer.presentation.viewmodels.TrackViewModel
import cl.svasquezm.glitunesplayer.utils.GLItunesPlayerApplication.Dependencies

@Suppress("UNCHECKED_CAST")
class TrackListFragment : Fragment() {
    lateinit var presenter: TrackListPresenter

    val viewModel = ViewModelProvider(this, object: ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return TrackViewModel(Dependencies.getTracksByTermUseCase) as T
        }
    }).get(TrackViewModel::class.java)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        container?.let {
            presenter = TrackListPresenter(container)
        }

        return presenter.recyclerView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getTracks(observer = this, onChange = {
            presenter.updateView(it)
        })
    }
}
