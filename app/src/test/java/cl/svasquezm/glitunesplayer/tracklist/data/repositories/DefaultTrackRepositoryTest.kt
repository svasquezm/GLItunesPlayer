package cl.svasquezm.glitunesplayer.tracklist.data.repositories

import cl.svasquezm.glitunesplayer.data.repositories.DefaultTrackRepository
import cl.svasquezm.glitunesplayer.domain.models.TrackDomainModel
import cl.svasquezm.glitunesplayer.tracklist.data.utils.createMockDataSourceFactory
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Test

class DefaultTrackRepositoryTest {

    private val repo = mockk<DefaultTrackRepository>()

    @Test
    fun `Find tracks by term should return a data source`() = runBlockingTest {
        val term = "Foo"
        val track: TrackDomainModel = mockk()
        val results = createMockDataSourceFactory(listOf(track))

        coEvery { repo.findAllTracks(term) } returns results

        Assert.assertEquals(results, repo.findAllTracks(term))
    }

    @Test
    fun `Find tracks by collection should return a data source`() = runBlockingTest {
        val collectionId = 100L
        val track: TrackDomainModel = mockk()
        val results = createMockDataSourceFactory(listOf(track))

        coEvery { repo.findAllTracksByCollection(collectionId) } returns results

        Assert.assertEquals(results, repo.findAllTracksByCollection(collectionId))
    }
}
