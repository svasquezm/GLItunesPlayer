package cl.svasquezm.glitunesplayer.tracklist.data.usecases

import androidx.paging.DataSource
import cl.svasquezm.glitunesplayer.data.usecases.GetTracksByTermUseCase
import cl.svasquezm.glitunesplayer.domain.models.TrackDomainModel
import cl.svasquezm.glitunesplayer.domain.repositories.TrackRepository
import cl.svasquezm.glitunesplayer.tracklist.data.utils.asPagedListLiveData
import io.mockk.coEvery
import io.mockk.*
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

class GetTracksByTermUseCaseTest {

    @Test
    fun `Use case should return 2 tracks`() = runBlockingTest {
        val term = "Foo"
        val factory = mockk<DataSource.Factory<Int, TrackDomainModel>>()
        val list = listOf(mockk<TrackDomainModel>()).asPagedListLiveData()

        val repo = mockk<TrackRepository>()
        val uc: GetTracksByTermUseCase = GetTracksByTermUseCase(repo)

        coEvery { repo.findAllTracks(term) } returns factory
        coEvery { uc.execute(term) } returns list

        uc.execute(term)

        coVerify { repo.findAllTracks(term) }
    }
}
