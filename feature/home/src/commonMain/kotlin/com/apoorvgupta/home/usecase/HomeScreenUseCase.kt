package com.apoorvgupta.home.usecase

import com.apoorvgupta.home.model.HomeDataModel

/**
 * @author Apoorv Gupta
 */
fun interface HomeScreenUseCase {
    suspend fun getHomeScreenContentData(): HomeDataModel
}