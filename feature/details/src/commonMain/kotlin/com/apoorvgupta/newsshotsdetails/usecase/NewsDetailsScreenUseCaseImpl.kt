package com.apoorvgupta.newsshotsdetails.usecase

import com.apoorvgupta.core.model.DataStatus
import com.apoorvgupta.core.model.ErrorModel
import com.apoorvgupta.core.model.onError
import com.apoorvgupta.core.model.onSuccess
import com.apoorvgupta.domain.model.NewsShots
import com.apoorvgupta.domain.usecase.GetIndividualNewsShotsUseCase
import com.apoorvgupta.newsshotsdetails.model.NewsDetailsDataModel

/**
 * @author Apoorv Gupta
 */
class NewsDetailsScreenUseCaseImpl(
    private val getIndividualNewsShotsUseCase: GetIndividualNewsShotsUseCase,
) : NewsDetailsScreenUseCase {

    override suspend fun getNewsDetailsContentData(postLink: String): NewsDetailsDataModel {
        lateinit var newsDetailsDataModel: NewsDetailsDataModel

        getIndividualNewsShotsUseCase(postLink)
            .onSuccess {
                newsDetailsDataModel = getNewsDetailsData(
                    newsShot = it ?: NewsShots.emptyValue,
                )
            }
            .onError { err, code ->
                newsDetailsDataModel = emitNewsDetailError(
                    statusCode = code,
                    message = err.name,
                )
            }

        return newsDetailsDataModel
    }

    private fun getNewsDetailsData(
        newsShot: NewsShots,
    ) = NewsDetailsDataModel(
        status = DataStatus.Success,
        newsShot = newsShot,
    )

    private fun emitNewsDetailError(
        statusCode: Int,
        message: String,
    ) = NewsDetailsDataModel(
        status = DataStatus.Error,
        errorModel = ErrorModel(
            errorCode = statusCode,
            message = message,
        ),
    )
}
