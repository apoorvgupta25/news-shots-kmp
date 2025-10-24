package com.apoorvgupta.home.viewmodel

import androidx.lifecycle.viewModelScope
import com.apoorvgupta.core.base.BaseViewModel
import com.apoorvgupta.core.model.DataStatus
import com.apoorvgupta.domain.model.AppThemeOptions
import com.apoorvgupta.domain.usecase.datastore.LoadAppThemeUseCase
import com.apoorvgupta.domain.usecase.datastore.UpdateAppThemeUseCase
import com.apoorvgupta.home.intent.HomeIntent
import com.apoorvgupta.home.intent.HomeNavEffect
import com.apoorvgupta.home.intent.HomeViewState
import com.apoorvgupta.home.intent.HomeViewStates
import com.apoorvgupta.home.model.HomeDataModel
import com.apoorvgupta.home.usecase.HomeScreenUseCase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

/**
 * ViewModel class for the home screen.
 *
 * @author Apoorv Gupta
 */

class HomeViewModel(
    private val homeScreenUseCase: HomeScreenUseCase,
    private val updateAppThemeUseCase: UpdateAppThemeUseCase,
    private val loadAppThemeUseCase: LoadAppThemeUseCase,
) : BaseViewModel<HomeIntent, HomeViewState, HomeNavEffect>() {

    override fun createInitialState(): HomeViewState = HomeViewState(HomeViewStates.UnInitialized)

    override fun handleIntent(intent: HomeIntent) {
        when (intent) {
            HomeIntent.LoadHomeScreen -> {
                getHomeData()
            }

            HomeIntent.ToggleAppTheme -> {
                updateAppTheme()
            }

            is HomeIntent.NavigateToNewsShotsListing -> {
                sendNavEffect { HomeNavEffect.OpenNewsShotsListingPage(intent.categoryName) }
            }

            is HomeIntent.NavigateToIndividualNewsShots -> {
                sendNavEffect { HomeNavEffect.OpenIndividualNewsShots(intent.postLink) }
            }
        }
    }

    private fun updateAppTheme() {
        val current = currentState.homeViewState as HomeViewStates.LoadedData
        viewModelScope.launch {

            val targetTheme =
                when (current.data.currentTheme) {
                    AppThemeOptions.LIGHT -> AppThemeOptions.DARK
                    AppThemeOptions.DARK -> AppThemeOptions.SYSTEM
                    AppThemeOptions.SYSTEM -> AppThemeOptions.LIGHT
                }

            updateAppThemeUseCase(targetTheme)
        }

        viewModelScope.launch {
            loadAppThemeUseCase.invoke().collect {
                emitHomeData(
                    homeDataModel = current.data.copy(
                        currentTheme = it
                    )
                )
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
