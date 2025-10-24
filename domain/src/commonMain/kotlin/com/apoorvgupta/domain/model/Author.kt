package com.apoorvgupta.domain.model

import com.apoorvgupta.newsshotskmp.core.utils.emptyValue

/**
 * @author Apoorv Gupta
 */
data class Author(
    val name: String
) {
    companion object {
        val emptyValue: Author
            get() = Author(
                name = String.emptyValue(),
            )
    }
}
