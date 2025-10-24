package com.apoorvgupta.newsshotsdetails.usecase

import com.apoorvgupta.newsshotsdetails.model.NewsDetailsDataModel
import kotlinx.coroutines.flow.Flow

/**
 * @author Apoorv Gupta
 */

fun interface NewsDetailsScreenUseCase {
    suspend fun getNewsDetailsContentData(postLink: String): NewsDetailsDataModel
}
