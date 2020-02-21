package cl.svasquezm.glitunesplayer.tracklist.domain

import cl.svasquezm.glitunesplayer.domain.models.SearchQueryModel
import org.junit.Assert
import org.junit.Test

class SearchQueryModelTest {

    @Test
    fun `Model should contain valid values`(){
        val id = 123L
        val query = "Foo"

        val model = SearchQueryModel(
            id = id,
            query = query
        )

        Assert.assertEquals(id, model.id)
        Assert.assertEquals(query, model.query)
    }
}