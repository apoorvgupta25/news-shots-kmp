package com.apoorvgupta.newsshotskmp.home.usecase

import com.apoorvgupta.newsshotskmp.home.model.HomeDataModel

/**
 * @author Apoorv Gupta
 */
fun interface HomeScreenUseCase {
    suspend fun getHomeScreenContentData(): HomeDataModel
}