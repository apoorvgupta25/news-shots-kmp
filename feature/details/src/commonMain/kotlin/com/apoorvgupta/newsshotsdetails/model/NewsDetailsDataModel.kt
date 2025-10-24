package com.apoorvgupta.newsshotsdetails.model

import com.apoorvgupta.core.model.DataStatus
import com.apoorvgupta.core.model.ErrorModel
import com.apoorvgupta.domain.model.NewsShots

/**
 * @author Apoorv Gupta
 */
data class NewsDetailsDataModel(
    val status: DataStatus = DataStatus.Empty,
    val errorModel: ErrorModel = ErrorModel(),
    val newsShot: NewsShots = NewsShots.emptyValue,
)
