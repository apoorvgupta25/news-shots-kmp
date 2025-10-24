package com.apoorvgupta.domain.usecase

import com.apoorvgupta.domain.model.Category
import com.apoorvgupta.core.model.DataError
import com.apoorvgupta.core.model.Result

/**
 * @author Apoorv Gupta
 */
fun interface GetAllCategoriesUseCase {
    suspend fun getAllCategories(): Result<List<Category>?, DataError.Remote>
}
