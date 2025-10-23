package com.apoorvgupta.newsshotskmp.capabilities

import com.apoorvgupta.newsshotskmp.capabilities.Constants.DateFormatConst.API_DATE_FORMAT
import com.apoorvgupta.newsshotskmp.capabilities.Constants.DateFormatConst.DATE_FORMAT


expect object DateUtils {
    /**
     * Get date formatted
     *
     * @param timestamp in format of "2025-03-23T00:00:00"
     * @param inputFormat Input Date Format
     * @param outputFormat Output Date Format
     * @return date in format of Mar 30, 2025
     */
    fun getDateFormatted(
        timestamp: String,
        inputFormat: String = API_DATE_FORMAT,
        outputFormat: String = DATE_FORMAT,
    ): String

}