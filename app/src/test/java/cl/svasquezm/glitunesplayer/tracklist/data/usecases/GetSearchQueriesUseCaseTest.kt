package cl.svasquezm.glitunesplayer.tracklist.data.usecases

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import cl.svasquezm.glitunesplayer.data.usecases.GetSearchQueriesUseCase
import cl.svasquezm.glitunesplayer.domain.models.SearchQueryModel
import cl.svasquezm.glitunesplayer.domain.repositories.SearchQueryRepository
import cl.svasquezm.glitunesplayer.tracklist.data.utils.LiveDataTestUtil
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class GetSearchQueriesUseCaseTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `Use case should return 1 query`() = runBlockingTest {
        val query = SearchQueryModel(0, "Foo")
        val list = MutableLiveData<List<SearchQueryModel>>(listOf(query))
        val repo = mockk<SearchQueryRepository>()
        val uc = GetSearchQueriesUseCase(repo)

        coEvery { repo.findAllQueries() } returns list
        val results = uc.execute()
        coVerify { repo.findAllQueries() }

        Assert.assertEquals(1, LiveDataTestUtil.getValue(results).size)
    }
}
