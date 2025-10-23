package com.apoorvgupta.newsshotskmp.capabilities

import platform.Foundation.NSDateFormatter
import platform.Foundation.NSTimeZone
import platform.Foundation.localTimeZone
import platform.Foundation.timeZoneWithAbbreviation

actual object DateUtils {
    actual fun getDateFormatted(
        timestamp: String,
        inputFormat: String,
        outputFormat: String
    ): String {

        val df = NSDateFormatter().apply {
            dateFormat = inputFormat
//            timeZone = NSTimeZone.timeZoneWithAbbreviation("GMT")!!
        }

        val date = df.dateFromString(timestamp)
        df.timeZone = NSTimeZone.localTimeZone
//        df.dateFormat = outputFormat

        return df.stringFromDate(date!!)
    }
}