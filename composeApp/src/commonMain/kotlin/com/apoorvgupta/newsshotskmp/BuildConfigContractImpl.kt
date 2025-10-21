package com.apoorvgupta.newsshotskmp

import com.apoorvgupta.newsshotskmp.core.interactions.buildConfigProvider.BuildConfigContract

class BuildConfigContractImpl : BuildConfigContract {

    /**
     * Retrieves the base URL for network requests.
     */
    override fun getBaseUrl(): String = "https://news-shots-backend.onrender.com"

    /**
     * Retrieves the version name of the application.
     */
    override fun getAppVersion(): String = "VERSION_NAME"

    /**
     * Retrieves the application ID.
     */
    override fun getApplicationId(): String = "BuildConfig.APPLICATION_ID"
}
