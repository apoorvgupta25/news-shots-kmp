package com.apoorvgupta.newsshotskmp.capabilities

import com.apoorvgupta.newsshotskmp.core.utils.emptyValue
import platform.Foundation.NSDateFormatter
import platform.Foundation.NSTimeZone
import platform.Foundation.localTimeZone

actual object DateUtils {
    actual fun getDateFormatted(
        timestamp: String,
        inputFormat: String,
        outputFormat: String
    ): String {
        // input date format
        val df = NSDateFormatter().apply { dateFormat = inputFormat }

        return try {
            // parsing
            val date = df.dateFromString(timestamp)
            df.timeZone = NSTimeZone.localTimeZone
            df.dateFormat = outputFormat

            // output date format
            if (date != null) {
                df.stringFromDate(date)
            } else {
                String.emptyValue()
            }
        } catch (e: Exception) {
            String.emptyValue()
        }
    }
}