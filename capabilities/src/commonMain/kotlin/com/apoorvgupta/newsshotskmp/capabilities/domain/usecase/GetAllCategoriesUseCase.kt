package com.apoorvgupta.newsshotskmp.capabilities.domain.usecase

import com.apoorvgupta.newsshotskmp.capabilities.domain.Category
import com.apoorvgupta.newsshotskmp.core.domain.DataError
import com.apoorvgupta.newsshotskmp.core.domain.Result

/**
 * @author Apoorv Gupta
 */
fun interface GetAllCategoriesUseCase {
    suspend fun getAllCategories(): Result<List<Category>?, DataError.Remote>
}
