package cl.svasquezm.glitunesplayer.tracklist.data.repositories

import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.room.paging.LimitOffsetDataSource
import cl.svasquezm.glitunesplayer.data.repositories.DefaultTrackRepository
import cl.svasquezm.glitunesplayer.domain.models.TrackDomainModel
import cl.svasquezm.glitunesplayer.tracklist.data.utils.asPagedListLiveData
import cl.svasquezm.glitunesplayer.tracklist.data.utils.createMockDataSourceFactory
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert
import org.junit.Test

class DefaultTrackRepositoryTest {

    private val repo = mockk<DefaultTrackRepository>()

    @Test
    fun `Find tracks by term should return a data source`(){
        val term = "Foo"
        val track: TrackDomainModel = mockk()
        val results = createMockDataSourceFactory(listOf(track))

        every { repo.findAllTracks(term) } returns results

        Assert.assertEquals(results, repo.findAllTracks(term))
    }

    @Test
    fun `Find tracks by collection should return a data source`(){
        val collectionId = "Foo.bar"
        val track: TrackDomainModel = mockk()
        val results = createMockDataSourceFactory(listOf(track))

        every { repo.findAllTracksByCollection(collectionId) } returns results

        Assert.assertEquals(results, repo.findAllTracks(collectionId))
    }
}
