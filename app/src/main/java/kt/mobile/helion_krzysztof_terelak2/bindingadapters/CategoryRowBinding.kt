package kt.mobile.helion_krzysztof_terelak2.bindingadapters

import android.util.Log
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import kt.mobile.helion_krzysztof_terelak2.data.entities.Category
import kt.mobile.helion_krzysztof_terelak2.fragment.home.HomeFragmentDirections

class CategoryRowBinding {

    companion object{

        @BindingAdapter("onCategoryClickListener")
        @JvmStatic
        fun onCategoryClickListener(categoryRowLayout: ConstraintLayout, category:Category){
            categoryRowLayout.setOnClickListener {
                try {
                    val action =
                        HomeFragmentDirections.actionHomeFragmentToMyDialog(category)
                    categoryRowLayout.findNavController().navigate(action)
                } catch (e: Exception) {
                    Log.d("onRecipeClickListener", e.toString())
                }
            }
        }
    }



}