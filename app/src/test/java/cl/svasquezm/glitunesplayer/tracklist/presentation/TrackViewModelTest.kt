package cl.svasquezm.glitunesplayer.tracklist.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import cl.svasquezm.glitunesplayer.data.usecases.GetNetworkTracksByTermUseCase
import cl.svasquezm.glitunesplayer.data.usecases.GetTracksByTermUseCase
import cl.svasquezm.glitunesplayer.domain.models.TrackDomainModel
import cl.svasquezm.glitunesplayer.presentation.viewmodels.TrackViewModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test

class TrackViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    val getTracksByTermUseCase = mockk<GetTracksByTermUseCase>()
    val getNetworkTracksByTermUseCase = mockk<GetNetworkTracksByTermUseCase>()
    val viewModel = TrackViewModel(getTracksByTermUseCase, getNetworkTracksByTermUseCase)

    @Test
    fun `Use case should return 1 query`() = runBlockingTest {
        val term = "Foo"
        val list = listOf<TrackDomainModel>()

        coEvery { getTracksByTermUseCase.execute(term) } returns list
        viewModel.getTracks(term)
        coVerify { getTracksByTermUseCase.execute(term) }
    }
}
