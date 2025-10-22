package com.apoorvgupta.newsshotskmp.home.viewmodel

import androidx.lifecycle.viewModelScope
import com.apoorvgupta.newsshotskmp.core.base.BaseViewModel
import com.apoorvgupta.newsshotskmp.core.utils.DataStatus
import com.apoorvgupta.newsshotskmp.home.intent.HomeIntent
import com.apoorvgupta.newsshotskmp.home.intent.HomeNavEffect
import com.apoorvgupta.newsshotskmp.home.intent.HomeViewState
import com.apoorvgupta.newsshotskmp.home.intent.HomeViewStates
import com.apoorvgupta.newsshotskmp.home.model.HomeDataModel
import com.apoorvgupta.newsshotskmp.home.usecase.HomeScreenUseCase
import kotlinx.coroutines.launch

/**
 * ViewModel class for the home screen.
 *
 * @author Apoorv Gupta
 */

class HomeViewModel(
    private val homeScreenUseCase: HomeScreenUseCase,
) : BaseViewModel<HomeIntent, HomeViewState, HomeNavEffect>() {

    override fun createInitialState(): HomeViewState = HomeViewState(HomeViewStates.UnInitialized)

    override fun handleIntent(intent: HomeIntent) {
        when (intent) {
            HomeIntent.LoadHomeScreen -> {
                getHomeData()
            }

            is HomeIntent.NavigateToNewsShotsListing -> {
                sendNavEffect { HomeNavEffect.OpenNewsShotsListingPage(intent.categoryName) }
            }

            is HomeIntent.NavigateToIndividualNewsShots -> {
                sendNavEffect { HomeNavEffect.OpenIndividualNewsShots(intent.postLink) }
            }
        }
    }

    private fun getHomeData() {
        emitHomeData(HomeDataModel(status = DataStatus.Loading))

        viewModelScope.launch {
            emitHomeData(homeScreenUseCase.getHomeScreenContentData())
        }
    }

    private fun emitHomeData(homeDataModel: HomeDataModel) {
        val homeViewState = when (homeDataModel.status) {
            DataStatus.Success -> {
                HomeViewStates.LoadedData(
                    showLoader = false,
                    data = homeDataModel,
                )
            }

            DataStatus.Loading -> {
                HomeViewStates.Loading(
                    showLoader = true,
                    data = HomeDataModel(),
                )
            }

            DataStatus.Error,
            DataStatus.Offline,
            DataStatus.Empty,
                -> {
                HomeViewStates.ErrorData(
                    showLoader = false,
                    data = homeDataModel,
                )
            }
        }

        emitViewState { copy(homeViewState = homeViewState) }
    }
}
