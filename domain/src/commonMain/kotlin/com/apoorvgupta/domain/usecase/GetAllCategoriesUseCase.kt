package com.apoorvgupta.domain.usecase

import com.apoorvgupta.core.model.DataError
import com.apoorvgupta.core.model.Result
import com.apoorvgupta.domain.model.Category

/**
 * @author Apoorv Gupta
 */
fun interface GetAllCategoriesUseCase {
    suspend operator fun invoke(): Result<List<Category>?, DataError.Remote>
}
