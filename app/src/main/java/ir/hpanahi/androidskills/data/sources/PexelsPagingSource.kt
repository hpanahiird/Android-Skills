package ir.hpanahi.androidskills.data.sources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ir.hpanahi.androidskills.api.PexelsService
import ir.hpanahi.androidskills.data.models.PexelsPhoto

class PexelsPagingSource(
    private val pexelsService: PexelsService,
    private val query: String,
    private val orientation: String,
    private val size: String,
    private val color: String,
    private val locale: String,
) : PagingSource<Int, PexelsPhoto>() {

    private val pexelsStartingPageIndex = 1

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PexelsPhoto> {
        val page = params.key ?: pexelsStartingPageIndex
        return try {
            val response = pexelsService.searchPhotos(
                query,
                orientation,
                size,
                color,
                locale,
                page,
                params.loadSize
            )
            val photos = response.photos
            LoadResult.Page(
                data = photos,
                prevKey = if (page == pexelsStartingPageIndex) null else page - 1,
                nextKey = if (page == response.total_results / response.per_page) null else page + 1
            )
        } catch (exception: Exception) {
            exception.printStackTrace()
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, PexelsPhoto>): Int? {
        TODO("Not yet implemented")
    }
}