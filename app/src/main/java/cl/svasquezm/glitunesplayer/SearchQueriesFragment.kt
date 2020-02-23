package cl.svasquezm.glitunesplayer


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cl.svasquezm.glitunesplayer.presentation.viewmodels.SearchQueryViewModel
import cl.svasquezm.glitunesplayer.utils.GLItunesPlayerApplication

/**
 * A simple [Fragment] subclass.
 */
class SearchQueriesFragment : Fragment() {
    val viewModel by lazy {
        ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return SearchQueryViewModel(GLItunesPlayerApplication.Dependencies.getSearchQueriesUseCase) as T
            }
        }).get(SearchQueryViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return RecyclerView(activity!!).apply {
            layoutManager = LinearLayoutManager(this.context)
        }
    }
}
