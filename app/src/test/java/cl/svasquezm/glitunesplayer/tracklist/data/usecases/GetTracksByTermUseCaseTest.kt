package cl.svasquezm.glitunesplayer.tracklist.data.usecases

import androidx.paging.DataSource
import cl.svasquezm.glitunesplayer.data.usecases.GetTracksByTermUseCase
import cl.svasquezm.glitunesplayer.domain.models.TrackDomainModel
import cl.svasquezm.glitunesplayer.domain.repositories.TrackRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

class GetTracksByTermUseCaseTest {

    @Test
    fun `Use case should return 1 tracks`() = runBlockingTest {
        val term = "Foo"
        val factory = mockk<DataSource.Factory<Int, TrackDomainModel>>()

        val repo = mockk<TrackRepository>()
        val uc = GetTracksByTermUseCase(repo)

        coEvery { repo.findAllTracks(term) } returns factory
        uc.execute(term)
        coVerify { repo.findAllTracks(term) }
    }
}
