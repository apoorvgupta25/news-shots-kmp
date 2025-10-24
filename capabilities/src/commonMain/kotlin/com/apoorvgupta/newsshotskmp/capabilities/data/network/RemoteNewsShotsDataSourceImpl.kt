package com.apoorvgupta.newsshotskmp.capabilities.data.network

import com.apoorvgupta.newsshotskmp.capabilities.data.dto.category.CategoryDto
import com.apoorvgupta.newsshotskmp.capabilities.data.dto.newsshots.NewsShotsDto
import com.apoorvgupta.newsshotskmp.capabilities.data.helper.safeCall
import com.apoorvgupta.core.model.DataError
import com.apoorvgupta.core.model.Result
import com.apoorvgupta.core.interactions.buildConfigProvider.BuildConfigContract
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter

/**
 * @author Apoorv Gupta
 */

class RemoteNewsShotsDataSourceImpl(
    private val httpClient: HttpClient,
    private val buildConfigContract: BuildConfigContract,
) : RemoteNewsShotsDataSource {
    /**
     * Get daily news shots
     *
     * @param limit
     * @param skip
     * @param sortBy
     * @return
     */
    override suspend fun getDailyNewsShots(
        limit: Int,
        sortBy: String,
        skip: Int,
    ): Result<List<NewsShotsDto>, DataError.Remote> {
        return safeCall<List<NewsShotsDto>> {
            httpClient.get(
                urlString = appendBaseUrl("api/index/daily")
            ) {
                parameter("limit", limit)
                parameter("skip", skip)
                parameter("sortBy", sortBy)
            }
        }
    }

    /**
     * Get all categories
     *
     * @return
     */
    override suspend fun getAllCategories(): Result<List<CategoryDto>, DataError.Remote> {
        return safeCall<List<CategoryDto>> {
            httpClient.get(
                urlString = appendBaseUrl("api/all/categories")
            )
        }
    }

    /**
     * Get post by category
     *
     * @param categoryName
     * @param limit
     * @param skip
     * @return
     */
    override suspend fun getPostByCategory(
        categoryName: String,
        limit: Int,
        skip: Int,
    ): Result<List<NewsShotsDto>, DataError.Remote> {
        return safeCall<List<NewsShotsDto>> {
            httpClient.get(
                urlString = appendBaseUrl("api/index/category/$categoryName")
            ) {
                parameter("limit", limit)
                parameter("skip", skip)
            }
        }
    }

    /**
     * Get individual post
     *
     * @param postLink
     * @return
     */
    override suspend fun getIndividualPost(
        postLink: String,
    ): Result<NewsShotsDto, DataError.Remote> {
        return safeCall<NewsShotsDto> {
            httpClient.get(
                urlString = appendBaseUrl("api/daily/$postLink")
            )
        }
    }

    /**
     * Get searched post
     *
     * @param search
     * @return
     */
    override suspend fun getSearchedPost(
        search: String
    ): Result<List<NewsShotsDto>, DataError.Remote> {
        return safeCall<List<NewsShotsDto>> {
            httpClient.get(
                urlString = appendBaseUrl("api/find/regex/post")
            ) {
                parameter("search", search)
            }
        }
    }

    private fun appendBaseUrl(endpoint: String) = buildConfigContract.getBaseUrl() + "/$endpoint"
}


