package kt.mobile.helion_krzysztof_terelak2.util

import kt.mobile.helion_krzysztof_terelak2.data.entities.Categories

sealed class ViewState {
    object Loading : ViewState()
    data class Success(val data: Categories) : ViewState()
    data class Error(val exception: Throwable) : ViewState()
}
