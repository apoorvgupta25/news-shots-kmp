package com.apoorvgupta.network.helper

/**
 * Object containing constants used in the application.
 *
 * @author Apoorv Gupta
 */
object Constants {
    const val REQUEST_TIMEOUT = 60_000L
    const val POST_PER_PAGE = 8
    const val DAILY_POST_LIMIT = 3
    const val DAILY_POST_SORT_BY_CREATED = "createdAt"

    const val SUCCESS_RESPONSE_START = 200
    const val SUCCESS_RESPONSE_END = 299
    const val ERROR_RESPONSE_START = 500
    const val ERROR_RESPONSE_END = 599
    const val TIMEOUT_RESPONSE = 408
    const val TOO_MANY_RESPONSE = 429
}
