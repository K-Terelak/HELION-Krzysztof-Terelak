package kt.mobile.helion_krzysztof_terelak2.usecases

import kt.mobile.helion_krzysztof_terelak2.data.HelionGateway
import kt.mobile.helion_krzysztof_terelak2.data.entities.Categories
import javax.inject.Inject

class GetAllCategoriesUseCase @Inject constructor(
    private val helionGateway: HelionGateway
) {

    suspend operator fun invoke(): Categories {
        return helionGateway.getAllCategories()
    }

}