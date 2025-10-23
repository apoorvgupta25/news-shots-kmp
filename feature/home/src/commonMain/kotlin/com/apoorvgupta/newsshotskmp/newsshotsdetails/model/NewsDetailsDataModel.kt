package com.apoorvgupta.newsshotskmp.newsshotsdetails.model

import com.apoorvgupta.newsshotskmp.capabilities.domain.NewsShots
import com.apoorvgupta.newsshotskmp.core.domain.ErrorModel
import com.apoorvgupta.newsshotskmp.core.utils.DataStatus

/**
 * @author Apoorv Gupta
 */
data class NewsDetailsDataModel(
    val status: DataStatus = DataStatus.Empty,
    val errorModel: ErrorModel = ErrorModel(),
    val newsShot: NewsShots = NewsShots.emptyValue,
)
