package kt.mobile.helion_krzysztof_terelak2.data

import kt.mobile.helion_krzysztof_terelak2.data.entities.Categories
import kt.mobile.helion_krzysztof_terelak2.data.remote.RemoteDataSource
import javax.inject.Inject

class HelionRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
) : HelionGateway {

    override suspend fun getAllCategories(): Categories {
        return remoteDataSource.getAllCategories()
    }

}