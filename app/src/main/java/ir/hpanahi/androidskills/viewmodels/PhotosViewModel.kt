package ir.hpanahi.androidskills.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.hpanahi.androidskills.data.models.PexelsPhoto
import ir.hpanahi.androidskills.repositories.PexelsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel @Inject constructor(
    private val pexelsRepository: PexelsRepository
) : ViewModel() {
    private var currentQueryValue: String? = null
    private var currentSearchResult: Flow<PagingData<PexelsPhoto>>? = null

    fun searchPhotos(queryString: String): Flow<PagingData<PexelsPhoto>> {
        currentQueryValue = queryString
        val newResult: Flow<PagingData<PexelsPhoto>> =
            pexelsRepository.getSearchResultStream(queryString).cachedIn(viewModelScope)
        currentSearchResult = newResult
        return newResult
    }
}