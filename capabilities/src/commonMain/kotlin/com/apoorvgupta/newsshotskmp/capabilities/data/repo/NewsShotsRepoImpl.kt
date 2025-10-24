package com.apoorvgupta.newsshotskmp.capabilities.data.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.apoorvgupta.domain.model.NewsShots
import com.apoorvgupta.newsshotskmp.capabilities.Constants
import com.apoorvgupta.newsshotskmp.capabilities.data.mappers.toCategory
import com.apoorvgupta.newsshotskmp.capabilities.data.mappers.toNewsShots
import com.apoorvgupta.newsshotskmp.capabilities.data.network.NewsShotsPagingSource
import com.apoorvgupta.newsshotskmp.capabilities.data.network.RemoteNewsShotsDataSource
import com.apoorvgupta.domain.repo.NewsShotsRepo
import com.apoorvgupta.newsshotskmp.core.model.map
import kotlinx.coroutines.flow.Flow

/**
 * @author Apoorv Gupta
 */

class NewsShotsRepoImpl(
    private val remoteDataSource: RemoteNewsShotsDataSource,
) : NewsShotsRepo {

    override suspend fun getRecentNewsShots(
        limit: Int,
        sortBy: String
    ) = remoteDataSource.getDailyNewsShots(limit, sortBy)
        .map { dto ->
            dto.map { it.toNewsShots() }
        }

    override suspend fun getIndividualNewsShots(postLink: String) =
        remoteDataSource.getIndividualPost(postLink).map {
            it.toNewsShots()
        }

    override suspend fun getSearchedNewsShots(searchKeyword: String) =
        remoteDataSource.getSearchedPost(searchKeyword).map { dto ->
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
                    categoryName
                )
            },
        ).flow
    }

}