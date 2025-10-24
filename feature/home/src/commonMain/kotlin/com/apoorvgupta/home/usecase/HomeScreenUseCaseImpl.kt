package com.apoorvgupta.home.usecase

import com.apoorvgupta.domain.model.Category
import com.apoorvgupta.domain.model.NewsShots
import com.apoorvgupta.domain.usecase.GetAllCategoriesUseCase
import com.apoorvgupta.domain.usecase.GetRecentNewsShotsUseCase
import com.apoorvgupta.core.model.ErrorModel
import com.apoorvgupta.core.model.onError
import com.apoorvgupta.core.model.onSuccess
import com.apoorvgupta.core.model.DataStatus
import com.apoorvgupta.core.utils.getValueOrEmpty
import com.apoorvgupta.home.model.HomeContent
import com.apoorvgupta.home.model.HomeDataModel

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
