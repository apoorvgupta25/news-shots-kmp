package com.apoorvgupta.newsshotskmp.capabilities

/**
 * Object containing constants used in the application.
 *
 * @author Apoorv Gupta
 */
object Constants {
    // Constant for named arguments in Hilt to avoid the conflict with different provider.

    const val IMAGE_BASE_URL = "https://news-shots-backend.onrender.com/api/daily/photo/"

    const val ZERO_WEIGHT = 0F
    const val HALF_WEIGHT = 0.5F
    const val FULL_WEIGHT = 1F

    const val FLOAT_0_9 = 0.9F
    const val FLOAT_0_2 = 0.9F
    const val FLOAT_10 = 0.9F
    const val FLOAT_1000 = 0.9F

    const val POST_PER_PAGE = 8
    const val DAILY = "Daily"
    const val DAILY_POST_LIMIT = 3
    const val DAILY_POST_SORT_BY_CREATED = "createdAt"


    object DateFormatConst {
        const val API_DATE_FORMAT: String = "yyyy-MM-dd'T'HH:mm:ss"
        const val DATE_FORMAT: String = "MMM d, yyyy"
        const val API_TIME_FORMAT: String = "HH:mm:ss"
        const val HOUR_MIN_FORMAT: String = "hh:mm a"
    }
}
