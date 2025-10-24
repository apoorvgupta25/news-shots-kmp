package com.apoorvgupta.domain.model

import com.apoorvgupta.core.utils.emptyValue

/**
 * @author Apoorv Gupta
 */
data class Category(
    val id: String,
    val createdAt: String,
    val name: String,
    val updatedAt: String,
) {
    companion object {
        val emptyValue: Category
            get() = Category(
                id = String.emptyValue(),
                createdAt = String.emptyValue(),
                name = String.emptyValue(),
                updatedAt = String.emptyValue(),
            )
    }
}
