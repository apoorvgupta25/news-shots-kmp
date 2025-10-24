package com.apoorvgupta.newsshotskmp

import androidx.lifecycle.ViewModel
import com.apoorvgupta.domain.model.AppThemeOptions
import com.apoorvgupta.domain.usecase.datastore.LoadAppThemeUseCase
import kotlinx.coroutines.flow.Flow

internal class AppViewModel(
    private val loadAppThemeUsecase: LoadAppThemeUseCase,
) : ViewModel() {

    fun loadCurrentTheme(): Flow<AppThemeOptions> = loadAppThemeUsecase()
}
