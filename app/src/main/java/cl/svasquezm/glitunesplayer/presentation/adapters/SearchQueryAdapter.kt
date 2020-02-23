package cl.svasquezm.glitunesplayer.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.svasquezm.glitunesplayer.R
import cl.svasquezm.glitunesplayer.domain.models.SearchQueryModel
import cl.svasquezm.glitunesplayer.presentation.adapters.viewholders.SearchQueryViewHolder

class SearchQueryAdapter(private val queries: List<SearchQueryModel>) : RecyclerView.Adapter<SearchQueryViewHolder>() {

    override fun getItemCount() = queries.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = SearchQueryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item_search_query, parent, false))

    override fun onBindViewHolder(holder: SearchQueryViewHolder, position: Int) {
        holder.bind(queries[position])
    }
}
