package com.apoorvgupta.newsshotskmp.newsshotsdetails.model

import com.apoorvgupta.domain.model.NewsShots
import com.apoorvgupta.newsshotskmp.core.model.ErrorModel
import com.apoorvgupta.newsshotskmp.core.model.DataStatus

/**
 * @author Apoorv Gupta
 */
data class NewsDetailsDataModel(
    val status: DataStatus = DataStatus.Empty,
    val errorModel: ErrorModel = ErrorModel(),
    val newsShot: NewsShots = NewsShots.emptyValue,
)
