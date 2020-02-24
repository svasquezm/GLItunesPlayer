package cl.svasquezm.glitunesplayer.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import cl.svasquezm.glitunesplayer.R
import cl.svasquezm.glitunesplayer.presentation.adapters.TrackListAdapter
import cl.svasquezm.glitunesplayer.presentation.viewmodels.CollectionDetailsViewModel
import cl.svasquezm.glitunesplayer.presentation.viewmodels.TrackViewModel
import cl.svasquezm.glitunesplayer.utils.GLItunesPlayerApplication

/**
 * A simple [Fragment] subclass.
 */
@Suppress("UNCHECKED_CAST")
class CollectionDetailsFragment : Fragment() {
    val args by lazy { CollectionDetailsFragmentArgs.fromBundle(arguments!!) }

    val viewModel by lazy {
        ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return CollectionDetailsViewModel(
                    GLItunesPlayerApplication.Dependencies.getTrackByIdUseCase,
                    GLItunesPlayerApplication.Dependencies.getTracksByCollectionUseCase,
                    GLItunesPlayerApplication.Dependencies.getNetworkTracksByCollectionUseCase
                ) as T
            }
        }).get(CollectionDetailsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_collection_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Do it in a presenter
        val model = viewModel.getTrackByIdUseCase(args.trackId)
        view.findViewById<TextView>(R.id.artistName).text = model.artistName
        view.findViewById<TextView>(R.id.collectionName).text = model.collectionName
        
        val trackAdapter = TrackListAdapter(listOf())
        view.findViewById<RecyclerView>(R.id.trackList).apply {
            adapter = trackAdapter
        }

        viewModel.getCollectionTracks(args.collectionId)
        viewModel.collectionTracksLiveData.observe(this, Observer {
            trackAdapter.tracks = it
            trackAdapter.notifyDataSetChanged()
        })
    }
}
