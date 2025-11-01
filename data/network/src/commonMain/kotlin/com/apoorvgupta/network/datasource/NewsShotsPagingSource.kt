package com.apoorvgupta.network.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.apoorvgupta.core.model.onError
import com.apoorvgupta.core.model.onSuccess
import com.apoorvgupta.core.utils.emptyValue
import com.apoorvgupta.core.utils.getValueOrEmpty
import com.apoorvgupta.domain.model.NewsShots
import com.apoorvgupta.network.helper.Constants
import com.apoorvgupta.network.mappers.toNewsShots

/**
 * @author Apoorv Gupta
 */

class NewsShotsPagingSource(
    private val remoteDataSource: RemoteNewsShotsDataSource,
    private val perPageLimit: Int,
    private val categoryName: String = String.emptyValue(),
) : PagingSource<Int, NewsShots>() {

    override fun getRefreshKey(state: PagingState<Int, NewsShots>) =
        state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(Constants.POST_PER_PAGE)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(Constants.POST_PER_PAGE)
        }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NewsShots> {
        val page = params.key ?: 0

        return try {
            val response = if (categoryName.isEmpty()) {
                remoteDataSource.getDailyNewsShots(
                    limit = perPageLimit,
                    sortBy = Constants.DAILY_POST_SORT_BY_CREATED,
                    skip = page,
                )
            } else {
                remoteDataSource.getPostByCategory(categoryName, perPageLimit, page)
            }

            var successResponse: List<NewsShots>? = null
            response
                .onError { err, code ->
                    return LoadResult.Error(
                        Exception(
                            "$code ${err.name.getValueOrEmpty()}",
                        ),
                    )
                }
                .onSuccess {
                    successResponse = it.map { it.toNewsShots() }
                }

            LoadResult.Page(
                data = successResponse ?: emptyList(),
                prevKey = if (page == 0) null else page.minus(Constants.POST_PER_PAGE),
                nextKey = if (successResponse.isNullOrEmpty()) null else page.plus(Constants.POST_PER_PAGE),
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
