package com.apoorvgupta.domain.usecase

import androidx.paging.PagingData
import com.apoorvgupta.domain.model.NewsShots
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