package cl.svasquezm.glitunesplayer.presentation.adapters.viewholders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cl.svasquezm.glitunesplayer.R
import cl.svasquezm.glitunesplayer.domain.models.SearchQueryModel

class SearchQueryViewHolder(view: View) : RecyclerView.ViewHolder(view){
    private val query = view.findViewById<TextView>(R.id.query)

    fun bind(queryModel: SearchQueryModel){
        query.text = queryModel.query
    }
}
