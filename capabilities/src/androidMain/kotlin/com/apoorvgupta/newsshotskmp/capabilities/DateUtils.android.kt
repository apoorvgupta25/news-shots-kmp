package com.apoorvgupta.newsshotskmp.capabilities

import com.apoorvgupta.newsshotskmp.core.utils.emptyValue
import java.text.SimpleDateFormat
import java.util.Locale

actual object DateUtils {
    actual fun getDateFormatted(
        timestamp: String,
        inputFormat: String,
        outputFormat: String
    ): String {
        // input date format
        val simpleDateFormat = SimpleDateFormat(inputFormat, Locale.getDefault())

        return try {
            // parsing
            val newDate = simpleDateFormat.parse(timestamp)

            // output date format
            if (newDate != null) {
                SimpleDateFormat(outputFormat, Locale.getDefault()).format(newDate)
            } else {
                String.emptyValue()
            }
        } catch (e: Exception) {
            String.emptyValue()
        }
    }
}