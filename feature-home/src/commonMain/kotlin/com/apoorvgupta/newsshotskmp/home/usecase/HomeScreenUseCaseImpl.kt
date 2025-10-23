package com.apoorvgupta.newsshotskmp.home.usecase

import com.apoorvgupta.newsshotskmp.capabilities.domain.Category
import com.apoorvgupta.newsshotskmp.capabilities.domain.NewsShots
import com.apoorvgupta.newsshotskmp.capabilities.domain.usecase.GetAllCategoriesUseCase
import com.apoorvgupta.newsshotskmp.capabilities.domain.usecase.GetRecentNewsShotsUseCase
import com.apoorvgupta.newsshotskmp.core.domain.ErrorModel
import com.apoorvgupta.newsshotskmp.core.domain.onError
import com.apoorvgupta.newsshotskmp.core.domain.onSuccess
import com.apoorvgupta.newsshotskmp.core.logger.AppLogger
import com.apoorvgupta.newsshotskmp.core.utils.DataStatus
import com.apoorvgupta.newsshotskmp.core.utils.getValueOrEmpty
import com.apoorvgupta.newsshotskmp.home.model.HomeContent
import com.apoorvgupta.newsshotskmp.home.model.HomeDataModel
import com.apoorvgupta.newsshotskmp.home.usecase.HomeScreenUseCase
import kotlinx.coroutines.flow.FlowCollector

/**
 * @author Apoorv Gupta
 */
class HomeScreenUseCaseImpl(
    private val getRecentNewsShotsUseCase: GetRecentNewsShotsUseCase,
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase,
) : HomeScreenUseCase {

    var homeDataModel = HomeDataModel()

    override suspend fun getHomeScreenContentData(): HomeDataModel {

        getRecentNewsShotsUseCase.getRecentNewsShots()
            .onSuccess { newsshots ->
                getAllCategoriesUseCase.getAllCategories()
                    .onSuccess { categories ->
                        homeDataModel = getHomeData(newsshots, categories)
                    }
                    .onError { err, code ->
                        homeDataModel = emitHomeError(
                            statusCode = code.getValueOrEmpty(),
                            message = err.name.getValueOrEmpty(),
                        )
                    }
            }
            .onError { err, code ->
                getAllCategoriesUseCase.getAllCategories()
                    .onSuccess { categories ->
                        homeDataModel = getHomeData(null, categories)
                    }
                    .onError { err, code ->
                        homeDataModel = emitHomeError(
                            statusCode = code.getValueOrEmpty(),
                            message = err.name.getValueOrEmpty(),
                        )
                    }
            }

        return homeDataModel
    }


    private fun getHomeData(
        newsShotsList: List<NewsShots>?,
        categoriesList: List<Category>?,
    ): HomeDataModel {
        return HomeDataModel(
            status = DataStatus.Success,
            homeContent = HomeContent(
                headingText = "NewsShots Daily",
                subHeadingText = "Get daily news in 3 mins",
                articlesLabel = "Latest articles",
            ),
            newsShotsList = newsShotsList.getValueOrEmpty(),
            categoriesList = categoriesList.getValueOrEmpty(),
        )
    }

    private fun emitHomeError(
        statusCode: Int,
        message: String = "",
    ) = HomeDataModel(
        status = DataStatus.Error,
        errorModel = ErrorModel(
            errorCode = statusCode,
            message = message,
        ),
    )

}
