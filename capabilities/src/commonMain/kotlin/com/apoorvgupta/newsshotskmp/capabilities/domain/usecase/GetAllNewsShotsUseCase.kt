package com.apoorvgupta.newsshotskmp.capabilities.domain.usecase

import androidx.paging.PagingData
import com.apoorvgupta.newsshotskmp.capabilities.domain.NewsShots
import kotlinx.coroutines.flow.Flow


/**
 * Get all news shots use case
 *
 * @constructor Create empty Get all news shots use case
 *
 * @author Apoorv Gupta
 */
fun interface GetAllNewsShotsUseCase {
    fun getAllNewsShots(): Flow<PagingData<NewsShots>>
}