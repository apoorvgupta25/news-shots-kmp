package com.apoorvgupta.newsshotskmp.home.navigation

import com.apoorvgupta.newsshotskmp.home.model.HomeDataModel

/**
 * @author Apoorv Gupta
 */
fun interface HomeScreenUseCase {
    suspend fun getHomeScreenContentData(): HomeDataModel
}
