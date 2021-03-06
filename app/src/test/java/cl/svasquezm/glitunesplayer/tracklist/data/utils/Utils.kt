package cl.svasquezm.glitunesplayer.tracklist.data.utils

import android.database.Cursor
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.room.RoomDatabase
import androidx.room.RoomSQLiteQuery
import androidx.room.paging.LimitOffsetDataSource
import io.mockk.every
import io.mockk.mockk
import org.jetbrains.annotations.TestOnly
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

/**
 * Converts a List to PagedList for testing
 */
fun <T> List<T>.asPagedListLiveData() = LivePagedListBuilder<Int, T>(
    createMockDataSourceFactory(this),
    PagedList.Config.Builder()
        .setPageSize(10)
        .setEnablePlaceholders(false)
        .build()).build()

/**
 * Creates a DataSource.Factory for testing
 */
fun <T>createMockDataSourceFactory(items: List<T>) = object : DataSource.Factory<Int, T>() {
    override fun create() = MockLimitDataSource(items)
}
/**
 * Dummy RoomDatabase for testing
 */
val db: RoomDatabase = mockk {
    every { invalidationTracker } returns mockk(relaxUnitFun = true)
}

/**
 * Dummy Room Query for testing
 */
val query: RoomSQLiteQuery = mockk {
    every { sql } returns ""
}
/**
 * Dummy DataSource.Factory for testing
 */
class MockLimitDataSource<T>(private val itemList: List<T>) : LimitOffsetDataSource<T>(
    db,
    query, false, null) {
    override fun convertRows(cursor: Cursor?): MutableList<T> = itemList.toMutableList()
    override fun countItems(): Int = itemList.count()
    override fun isInvalid(): Boolean = false
    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<T>) { }
    override fun loadRange(startPosition: Int, loadCount: Int) =
        itemList.subList(startPosition, startPosition + loadCount).toMutableList()

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<T>) {
        callback.onResult(itemList, 0)
    }
}

object LiveDataTestUtil {
    @Suppress("UNCHECKED_CAST")
    @TestOnly
    @Throws(InterruptedException::class)
    fun <T> getValue(liveData: LiveData<T>): T {
        val data = arrayOfNulls<Any>(1)
        val latch = CountDownLatch(1)
        val observer = object : Observer<T> {
            override fun onChanged(t: T) {
                data[0] = t
                latch.countDown()
                liveData.removeObserver(this)
            }

        }
        liveData.observeForever(observer)
        latch.await(2, TimeUnit.SECONDS)

        return data[0] as T
    }
}