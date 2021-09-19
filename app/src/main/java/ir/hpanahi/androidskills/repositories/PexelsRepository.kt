package ir.hpanahi.androidskills.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import ir.hpanahi.androidskills.api.PexelsService
import ir.hpanahi.androidskills.data.models.PexelsPhoto
import ir.hpanahi.androidskills.data.sources.PexelsPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PexelsRepository @Inject constructor(private val pexelsService: PexelsService) {

    fun getSearchResultStream(query: String): Flow<PagingData<PexelsPhoto>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = NETWORK_PAGE_SIZE),
            pagingSourceFactory = { PexelsPagingSource(pexelsService, query, "", "", "", "") }
        ).flow
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 15
    }
}