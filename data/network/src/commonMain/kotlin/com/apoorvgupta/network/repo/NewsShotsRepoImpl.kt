package com.apoorvgupta.network.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.apoorvgupta.core.model.map
import com.apoorvgupta.domain.model.NewsShots
import com.apoorvgupta.domain.repo.NewsShotsRepo
import com.apoorvgupta.network.datasource.NewsShotsPagingSource
import com.apoorvgupta.network.datasource.RemoteNewsShotsDataSource
import com.apoorvgupta.network.helper.Constants
import com.apoorvgupta.network.mappers.toCategory
import com.apoorvgupta.network.mappers.toNewsShots
import kotlinx.coroutines.flow.Flow
import kotlin.collections.map

/**
 * @author Apoorv Gupta
 */

class NewsShotsRepoImpl(
    private val remoteDataSource: RemoteNewsShotsDataSource,
) : NewsShotsRepo {

    override suspend fun getRecentNewsShots(
        limit: Int,
        sortBy: String,
    ) = remoteDataSource.getDailyNewsShots(limit, sortBy)
        .map { dto ->
            dto.map { it.toNewsShots() }
        }

    override suspend fun getIndividualNewsShots(postLink: String) = remoteDataSource.getIndividualPost(postLink).map {
        it.toNewsShots()
    }

    override suspend fun getSearchedNewsShots(searchKeyword: String) = remoteDataSource.getSearchedPost(searchKeyword).map { dto ->
        dto.map { it.toNewsShots() }
    }

    override suspend fun getCategories() = remoteDataSource.getAllCategories().map { dto ->
        dto.map { it.toCategory() }
    }

    override fun getAllNewsShots(): Flow<PagingData<NewsShots>> {
        val perPageLimit = Constants.POST_PER_PAGE
        return Pager(
            config = PagingConfig(pageSize = perPageLimit),
            pagingSourceFactory = { NewsShotsPagingSource(remoteDataSource, perPageLimit) },
        ).flow
    }

    override fun getNewsShotsByCategory(categoryName: String): Flow<PagingData<NewsShots>> {
        val perPageLimit = Constants.POST_PER_PAGE
        return Pager(
            config = PagingConfig(pageSize = perPageLimit),
            pagingSourceFactory = {
                NewsShotsPagingSource(
                    remoteDataSource,
                    perPageLimit,
                    categoryName,
                )
            },
        ).flow
    }
}
