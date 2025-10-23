package com.apoorvgupta.newsshotskmp.newsshotsdetails.usecase

import com.apoorvgupta.newsshotskmp.newsshotsdetails.model.NewsDetailsDataModel
import kotlinx.coroutines.flow.Flow

/**
 * @author Apoorv Gupta
 */

fun interface NewsDetailsScreenUseCase {
    suspend fun getNewsDetailsContentData(postLink: String): NewsDetailsDataModel
}
