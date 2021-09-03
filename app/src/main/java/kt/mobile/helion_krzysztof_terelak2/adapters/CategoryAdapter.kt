package kt.mobile.helion_krzysztof_terelak2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kt.mobile.helion_krzysztof_terelak2.data.entities.Categories
import kt.mobile.helion_krzysztof_terelak2.data.entities.Category
import kt.mobile.helion_krzysztof_terelak2.databinding.CategoryRowLayoutBinding
import kt.mobile.helion_krzysztof_terelak2.util.CategoriesDiffUtil

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {

    private var categories = emptyList<Category>()

    class MyViewHolder(private val binding: CategoryRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(category: Category) {
            binding.category = category
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CategoryRowLayoutBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentCategory = categories[position]
        holder.bind(currentCategory)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    fun setData(newData: Categories) {
        val categoriesDiffUtil = CategoriesDiffUtil(categories, newData.categories ?: emptyList())
        val diffUtilResult = DiffUtil.calculateDiff(categoriesDiffUtil)
        categories = newData.categories ?: emptyList()
        diffUtilResult.dispatchUpdatesTo(this)
    }


}