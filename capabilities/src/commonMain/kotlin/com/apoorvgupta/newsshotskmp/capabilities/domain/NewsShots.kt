package com.apoorvgupta.newsshotskmp.capabilities.domain

import com.apoorvgupta.newsshotskmp.core.utils.emptyValue

/**
 * @author Apoorv Gupta
 */
data class NewsShots(
    val id: String,
    val author: Author,
    val category: Category,
    val content: String? = null,
    val createdAt: String,
    val description: String,
    val link: String,
    val title: String,
    val updatedAt: String? = null,
) {

    // TODO DATE
//    val formattedDate: String
//        get() = getDateFormatted(createdAt.getValueOrEmpty())

//    val draftJSContent: DraftJS
//        get() = Gson().fromJson(content, DraftJS::class.java)

    companion object {
        val emptyValue: NewsShots
            get() = NewsShots(
                id = String.emptyValue(),
                author = Author.emptyValue,
                category = Category.emptyValue,
                content = String.emptyValue(),
                createdAt = String.emptyValue(),
                description = String.emptyValue(),
                title = String.emptyValue(),
                link = String.emptyValue(),
            )
    }
}

