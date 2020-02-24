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
import androidx.navigation.fragment.findNavController
import cl.svasquezm.glitunesplayer.R
import cl.svasquezm.glitunesplayer.presentation.presenters.TrackListPresenter
import cl.svasquezm.glitunesplayer.presentation.viewmodels.TrackViewModel
import cl.svasquezm.glitunesplayer.utils.GLItunesPlayerApplication.Dependencies

@Suppress("UNCHECKED_CAST")
class TrackListFragment : Fragment(), SearchView.OnQueryTextListener {
    lateinit var presenter: TrackListPresenter

    val viewModel by lazy {
        ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return TrackViewModel(
                    Dependencies.getTracksByTermUseCase,
                    Dependencies.getTrNetworkTracksByTermUseCase
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
        viewModel.getTracks()
        viewModel.liveData.observe(this, Observer {
            presenter.updateView(it)
        })

        presenter.setOnTrackClickListener {
            val dest = TrackListFragmentDirections.actionTrackListFragmentToCollectionDetailsFragment(it.collectionId)
            findNavController().navigate(dest)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.track_menu, menu)

        val searchManager = context?.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu.findItem(R.id.search).actionView as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(activity?.componentName))
            setIconifiedByDefault(true)
            setOnQueryTextListener(this@TrackListFragment)
        }
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        viewModel.getTracks(newText?: "")
        return true
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        viewModel.getTracks(query?: "", true)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.search){
            findNavController().navigate(R.id.action_trackListFragment_to_searchQueriesFragment)
        }

        return super.onOptionsItemSelected(item)
    }
}
