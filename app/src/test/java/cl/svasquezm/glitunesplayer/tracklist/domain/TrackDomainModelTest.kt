package cl.svasquezm.glitunesplayer.tracklist.domain

import cl.svasquezm.glitunesplayer.domain.models.TrackDomainModel
import org.junit.Assert
import org.junit.Test

class TrackDomainModelTest {

    @Test
    fun `Model should contain valid values`(){
        val id = 12345L
        val name = "Foo"
        val artWorkUrl = "http://foo.bar"
        val artistName = "Foo"
        val collectionId = 1234L
        val collectionName = "Foo.bar"
        val previewUrl = "Foo.bar"
        val trackNumber = 12
        val isStreamable = true

        val model = TrackDomainModel(
            id = id,
            name = name,
            collectionId = collectionId,
            collectionName = collectionName,
            artWorkUrl = artWorkUrl,
            artistName = artistName,
            trackNumber = trackNumber,
            previewUrl = previewUrl,
            isStreamable = isStreamable
        )

        Assert.assertEquals(id, model.id)
        Assert.assertEquals(name, model.name)
        Assert.assertEquals(collectionId, model.collectionId)
        Assert.assertEquals(collectionName, model.collectionName)
        Assert.assertEquals(artWorkUrl, model.artWorkUrl)
        Assert.assertEquals(artistName, model.artistName)
        Assert.assertEquals(trackNumber, model.trackNumber)
        Assert.assertEquals(previewUrl, model.previewUrl)
        Assert.assertEquals(isStreamable, model.isStreamable)
    }
}