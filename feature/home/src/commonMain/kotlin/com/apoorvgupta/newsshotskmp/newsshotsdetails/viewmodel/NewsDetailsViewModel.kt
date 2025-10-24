package com.apoorvgupta.newsshotskmp.newsshotsdetails.viewmodel

import androidx.lifecycle.viewModelScope
import com.apoorvgupta.newsshotskmp.newsshotsdetails.usecase.NewsDetailsScreenUseCase
import com.apoorvgupta.core.base.BaseViewModel
import com.apoorvgupta.core.model.DataStatus
import com.apoorvgupta.core.utils.emptyValue
import com.apoorvgupta.newsshotskmp.newsshotsdetails.intent.NewsDetailsIntent
import com.apoorvgupta.newsshotskmp.newsshotsdetails.intent.NewsDetailsNavEffect
import com.apoorvgupta.newsshotskmp.newsshotsdetails.intent.NewsDetailsViewState
import com.apoorvgupta.newsshotskmp.newsshotsdetails.intent.NewsDetailsViewStates
import com.apoorvgupta.newsshotskmp.newsshotsdetails.model.NewsDetailsDataModel
import kotlinx.coroutines.launch

/**
 * @author Apoorv Gupta
 */
class NewsDetailsViewModel(
    private val newsDetailsScreenUseCase: NewsDetailsScreenUseCase,
) : BaseViewModel<NewsDetailsIntent, NewsDetailsViewState, NewsDetailsNavEffect>() {

    private var postLink: String = String.emptyValue()

    override fun createInitialState(): NewsDetailsViewState =
        NewsDetailsViewState(NewsDetailsViewStates.UnInitialized)

    override fun handleIntent(intent: NewsDetailsIntent) {
        when (intent) {
            is NewsDetailsIntent.LoadNewsDetailsScreen -> {
                postLink = intent.postLink
                getNewsDetails(intent.postLink)
            }

            is NewsDetailsIntent.ToggleBookMark -> {
            }

            is NewsDetailsIntent.NavigateToChromeCustomTab -> {
                sendNavEffect { NewsDetailsNavEffect.OpenChromeCustomTab(intent.link) }
            }

            is NewsDetailsIntent.NavigateToIndividualNewsShots -> {
                sendNavEffect { NewsDetailsNavEffect.OpenIndividualNewsShots(intent.link) }
            }

            NewsDetailsIntent.NavigateToPreviousScreen -> {
                sendNavEffect { NewsDetailsNavEffect.OpenPreviousScreen }
            }

            NewsDetailsIntent.RefreshNewsDetailsScreen -> {
                getNewsDetails(postLink)
            }
        }
    }

    private fun getNewsDetails(postLink: String) {
        emitDetailsData(NewsDetailsDataModel(status = DataStatus.Loading))
        viewModelScope.launch {
            emitDetailsData(newsDetailsScreenUseCase.getNewsDetailsContentData(postLink = postLink))
        }
    }

    private fun emitDetailsData(newsDetailsDataModel: NewsDetailsDataModel) {
        val newsDetailsViewState = when (newsDetailsDataModel.status) {
            DataStatus.Success -> {
                NewsDetailsViewStates.LoadedData(
                    showLoader = false,
                    data = newsDetailsDataModel,
                )
            }

            DataStatus.Loading -> {
                NewsDetailsViewStates.Loading(
                    showLoader = true,
                    data = NewsDetailsDataModel(),
                )
            }

            DataStatus.Error,
            DataStatus.Offline,
            DataStatus.Empty,
                -> {
                NewsDetailsViewStates.ErrorData(
                    showLoader = false,
                    data = newsDetailsDataModel,
                )
            }
        }

        emitViewState { copy(newsDetailsViewState = newsDetailsViewState) }
    }
}
