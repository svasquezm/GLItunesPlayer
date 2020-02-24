package cl.svasquezm.glitunesplayer.tracklist.data.usecases

import androidx.paging.DataSource
import cl.svasquezm.glitunesplayer.data.usecases.GetTracksByCollectionUseCase
import cl.svasquezm.glitunesplayer.data.usecases.GetTracksByTermUseCase
import cl.svasquezm.glitunesplayer.domain.models.TrackDomainModel
import cl.svasquezm.glitunesplayer.domain.repositories.TrackRepository
import cl.svasquezm.glitunesplayer.tracklist.data.utils.asPagedListLiveData
import io.mockk.coEvery
import io.mockk.*
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

class GetTracksByCollectionUseCaseTest {

    @Test
    fun `Use case should return 2 tracks`() = runBlockingTest {
        val collectionId = 100L

        val repo = mockk<TrackRepository>()
        val uc = GetTracksByCollectionUseCase(repo)

        coEvery { repo.findAllTracksByCollection(collectionId) } returns listOf()
        uc.execute(collectionId)
        coVerify { repo.findAllTracksByCollection(collectionId) }
    }
}
