package com.apoorvgupta.newsshotskmp.newsshotsdetails.usecase

import com.apoorvgupta.newsshotskmp.capabilities.domain.NewsShots
import com.apoorvgupta.newsshotskmp.capabilities.domain.usecase.GetIndividualNewsShotsUseCase
import com.apoorvgupta.newsshotskmp.core.domain.ErrorModel
import com.apoorvgupta.newsshotskmp.core.domain.onError
import com.apoorvgupta.newsshotskmp.core.domain.onSuccess
import com.apoorvgupta.newsshotskmp.core.utils.DataStatus
import com.apoorvgupta.newsshotskmp.newsshotsdetails.model.NewsDetailsDataModel

/**
 * @author Apoorv Gupta
 */
class NewsDetailsScreenUseCaseImpl(
    private val getIndividualNewsShotsUseCase: GetIndividualNewsShotsUseCase,
) : NewsDetailsScreenUseCase {

    override suspend fun getNewsDetailsContentData(postLink: String): NewsDetailsDataModel {
        lateinit var newsDetailsDataModel: NewsDetailsDataModel

        getIndividualNewsShotsUseCase.getIndividualNewsShots(postLink)
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


