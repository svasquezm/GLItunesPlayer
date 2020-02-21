package cl.svasquezm.glitunesplayer.tracklist.data.repositories

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import cl.svasquezm.glitunesplayer.data.repositories.DefaultSearchQueryRepository
import cl.svasquezm.glitunesplayer.data.repositories.DefaultTrackRepository
import cl.svasquezm.glitunesplayer.domain.models.SearchQueryModel
import cl.svasquezm.glitunesplayer.domain.models.TrackDomainModel
import cl.svasquezm.glitunesplayer.tracklist.data.utils.LiveDataTestUtil
import cl.svasquezm.glitunesplayer.tracklist.data.utils.createMockDataSourceFactory
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class DefaultSearchQueryRepositoryTest {

    private val repo = mockk<DefaultSearchQueryRepository>()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `Find queries should return a live data`() = runBlockingTest {
        val query = SearchQueryModel(0, "Foo")
        val results = MutableLiveData(listOf(query))

        coEvery { repo.findAllQueries() } returns results

        Assert.assertEquals(1, LiveDataTestUtil.getValue(repo.findAllQueries()).size)
    }
}
