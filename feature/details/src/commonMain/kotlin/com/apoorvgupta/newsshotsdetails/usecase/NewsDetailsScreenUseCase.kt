package com.apoorvgupta.newsshotsdetails.usecase

import com.apoorvgupta.newsshotsdetails.model.NewsDetailsDataModel

/**
 * @author Apoorv Gupta
 */

fun interface NewsDetailsScreenUseCase {
    suspend fun getNewsDetailsContentData(postLink: String): NewsDetailsDataModel
}
