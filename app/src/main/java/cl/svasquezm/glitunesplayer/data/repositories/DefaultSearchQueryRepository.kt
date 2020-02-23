package cl.svasquezm.glitunesplayer.data.repositories

import cl.svasquezm.glitunesplayer.data.databases.TrackRoomDatabase
import cl.svasquezm.glitunesplayer.domain.repositories.SearchQueryRepository

class DefaultSearchQueryRepository(private val db: TrackRoomDatabase) : SearchQueryRepository {
    override fun findAllQueries() = db.dao().findAllQueries()
}
