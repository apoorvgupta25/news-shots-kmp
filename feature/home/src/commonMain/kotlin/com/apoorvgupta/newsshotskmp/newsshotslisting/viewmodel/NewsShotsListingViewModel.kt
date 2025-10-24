package com.apoorvgupta.newsshotskmp.newsshotslisting.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.apoorvgupta.domain.model.NewsShots
import com.apoorvgupta.newsshotskmp.capabilities.Constants.DAILY
import com.apoorvgupta.domain.usecase.GetAllNewsShotsUseCase
import com.apoorvgupta.domain.usecase.GetNewsShotsByCategoryUseCase
import com.apoorvgupta.newsshotskmp.core.base.BaseViewModel
import com.apoorvgupta.newsshotskmp.core.utils.emptyValue
import com.apoorvgupta.newsshotskmp.newsshotslisting.intent.NewsShotsListingIntent
import com.apoorvgupta.newsshotskmp.newsshotslisting.intent.NewsShotsListingNavEffect
import com.apoorvgupta.newsshotskmp.newsshotslisting.intent.NewsShotsListingViewState
import com.apoorvgupta.newsshotskmp.newsshotslisting.intent.NewsShotsListingViewStates
import com.apoorvgupta.newsshotskmp.newsshotslisting.model.NewsShotsListingDataModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * @author Apoorv Gupta
 */

class NewsShotsListingViewModel (
    private val getAllNewsShotsUseCase: GetAllNewsShotsUseCase,
    private val getNewsShotsByCategoryUseCase: GetNewsShotsByCategoryUseCase,
) : BaseViewModel<NewsShotsListingIntent, NewsShotsListingViewState, NewsShotsListingNavEffect>() {

    private val _newsShotsPaginationResults: MutableStateFlow<PagingData<NewsShots>> =
        MutableStateFlow(value = PagingData.empty())

    val newsShotsPaginationResults: StateFlow<PagingData<NewsShots>> =
        _newsShotsPaginationResults.asStateFlow()

    private var categoryName: String = String.emptyValue()

    override fun createInitialState(): NewsShotsListingViewState = NewsShotsListingViewState(
        NewsShotsListingViewStates.UnInitialized)

    override fun handleIntent(intent: NewsShotsListingIntent) {
        when (intent) {
            is NewsShotsListingIntent.LoadNewsShotsListingScreen -> {
                categoryName = intent.categoryName
                getDailyData(intent.categoryName)
            }

            is NewsShotsListingIntent.NavigateToIndividualNewsShots -> {
                sendNavEffect { NewsShotsListingNavEffect.OpenIndividualNewsShots(intent.link) }
            }

            NewsShotsListingIntent.NavigateToPreviousScreen -> {
                sendNavEffect { NewsShotsListingNavEffect.OpenPreviousScreen }
            }

            NewsShotsListingIntent.RefreshNewsShotsListingScreen -> {
                getDailyData(categoryName)
            }
        }
    }

    private fun getDailyData(categoryName: String) {
        viewModelScope.launch {
            if (categoryName.equals(DAILY, true)) {
                getAllNewsShotsUseCase.getAllNewsShots().cachedIn(viewModelScope).collect {
                    _newsShotsPaginationResults.value = it
                    emitDailyData(categoryName)
                }
            } else {
                getNewsShotsByCategoryUseCase.getNewsShotsByCategory(categoryName = categoryName)
                    .cachedIn(viewModelScope).collect {
                        _newsShotsPaginationResults.value = it
                        emitDailyData(categoryName)
                    }
            }
        }
    }

    private fun emitDailyData(headingText: String) {
        emitViewState {
            copy(
                newsShotsListingViewState = NewsShotsListingViewStates.LoadedData(
                    showLoader = false,
                    data = NewsShotsListingDataModel(
                        headingText = headingText,
                    ),
                ),
            )
        }
    }

    /**
     * Emits a loading state to update the UI when initial loading is in progress.
     */
    fun emitLoading() {
        emitViewState {
            copy(
                newsShotsListingViewState = NewsShotsListingViewStates.InitialLoading(
                    showLoader = true,
                    data = NewsShotsListingDataModel(),
                ),
            )
        }
    }
}
