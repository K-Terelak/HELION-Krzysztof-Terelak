package kt.mobile.helion_krzysztof_terelak2.data.remote

import kt.mobile.helion_krzysztof_terelak2.data.remote.response.CategoriesResponse
import kt.mobile.helion_krzysztof_terelak2.util.Constants.ENDPOINT_CATEGORIES
import retrofit2.http.GET

interface HelionService {

    @GET(ENDPOINT_CATEGORIES)
    suspend fun getAllCategories(): CategoriesResponse
}