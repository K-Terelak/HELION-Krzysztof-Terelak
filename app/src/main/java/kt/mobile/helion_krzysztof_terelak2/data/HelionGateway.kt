package kt.mobile.helion_krzysztof_terelak2.data

import kt.mobile.helion_krzysztof_terelak2.data.entities.Categories

interface HelionGateway {

    suspend fun getAllCategories(): Categories

}