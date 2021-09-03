package kt.mobile.helion_krzysztof_terelak2.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kt.mobile.helion_krzysztof_terelak2.usecases.GetAllCategoriesUseCase
import kt.mobile.helion_krzysztof_terelak2.util.ViewState
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase,
    application: Application,
) : AndroidViewModel(application) {


    var categoryResponse: MutableLiveData<ViewState> = MutableLiveData(ViewState.Loading)


    fun getAllCategories() {
        viewModelScope.launch {
            try {
                categoryResponse.value = ViewState.Success(getAllCategoriesUseCase())
            } catch (e: Exception) {
                categoryResponse.value = ViewState.Error(e)
            }
        }
    }

}