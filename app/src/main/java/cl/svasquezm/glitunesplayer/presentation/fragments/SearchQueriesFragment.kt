package cl.svasquezm.glitunesplayer.presentation.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cl.svasquezm.glitunesplayer.R
import cl.svasquezm.glitunesplayer.presentation.adapters.SearchQueryAdapter
import cl.svasquezm.glitunesplayer.presentation.viewmodels.SearchQueryViewModel
import cl.svasquezm.glitunesplayer.utils.GLItunesPlayerApplication

/**
 * A simple [Fragment] subclass.
 */
@Suppress("UNCHECKED_CAST")
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
        return LayoutInflater.from(this.context).inflate(R.layout.fragment_search_queries, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<RecyclerView>(R.id.recyclerView).apply {
            addItemDecoration(DividerItemDecoration(this.context, LinearLayoutManager.VERTICAL))
            adapter = SearchQueryAdapter(viewModel.getQueries())
            adapter?.notifyDataSetChanged()
        }
    }
}
