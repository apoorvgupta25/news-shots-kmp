package com.apoorvgupta.newsshotskmp.capabilities.data.repo

import com.apoorvgupta.newsshotskmp.capabilities.data.mappers.toCategory
import com.apoorvgupta.newsshotskmp.capabilities.data.mappers.toNewsShots
import com.apoorvgupta.newsshotskmp.capabilities.data.network.RemoteNewsShotsDataSource
import com.apoorvgupta.newsshotskmp.capabilities.domain.Category
import com.apoorvgupta.newsshotskmp.capabilities.domain.repo.NewsShotsRepo
import com.apoorvgupta.newsshotskmp.core.domain.DataError
import com.apoorvgupta.newsshotskmp.core.domain.Result
import com.apoorvgupta.newsshotskmp.core.domain.map

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

}