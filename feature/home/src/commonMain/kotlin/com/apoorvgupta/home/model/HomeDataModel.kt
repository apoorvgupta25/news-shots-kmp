package com.apoorvgupta.home.model

import com.apoorvgupta.domain.model.Category
import com.apoorvgupta.domain.model.NewsShots
import com.apoorvgupta.core.model.ErrorModel
import com.apoorvgupta.core.model.DataStatus
import com.apoorvgupta.core.utils.emptyValue

/**
 * Data class representing data model required for Home Screen
 *
 * @property status The [DataStatus] representing the current status of the Search Landing screen data.
 * @property label
 * @constructor Create empty Home data model
 *
 * @author Apoorv Gupta
 */
data class HomeDataModel(
    val status: DataStatus = DataStatus.Empty,
    val errorModel: ErrorModel = ErrorModel(),
    val homeContent: HomeContent = HomeContent(),
    val newsShotsList: List<NewsShots> = emptyList(),
    val categoriesList: List<Category> = emptyList(),
)

data class HomeContent(
    val headingText: String = String.emptyValue(),
    val subHeadingText: String = String.emptyValue(),
    val articlesLabel: String = String.emptyValue(),
)
