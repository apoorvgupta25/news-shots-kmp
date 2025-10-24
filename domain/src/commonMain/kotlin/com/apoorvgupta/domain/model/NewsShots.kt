package com.apoorvgupta.domain.model

import com.apoorvgupta.draftjskmp.data.DraftJS
import com.apoorvgupta.newsshotskmp.core.utils.DateUtils.getDateFormatted
import com.apoorvgupta.newsshotskmp.core.utils.emptyValue
import com.apoorvgupta.newsshotskmp.core.utils.getValueOrEmpty
import kotlinx.serialization.json.Json

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

    val formattedDate: String
        get() = getDateFormatted(createdAt.getValueOrEmpty())

    val draftJSContent: DraftJS
        get() = deserializeDraftJS(content.getValueOrEmpty())

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

    fun deserializeDraftJS(content: String): DraftJS {
        return Json.decodeFromString(content)
    }
}

