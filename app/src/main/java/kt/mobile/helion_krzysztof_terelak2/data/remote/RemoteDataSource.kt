package kt.mobile.helion_krzysztof_terelak2.data.remote

import android.util.Log
import kt.mobile.helion_krzysztof_terelak2.data.entities.Categories
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val helionService: HelionService,
) {

    suspend fun getAllCategories(): Categories {
        Log.e("RDS", "getAllCategories called")
        return helionService.getAllCategories().asCategories()
    }

}