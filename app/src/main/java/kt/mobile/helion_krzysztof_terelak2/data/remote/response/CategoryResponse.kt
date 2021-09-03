package kt.mobile.helion_krzysztof_terelak2.data.remote.response


import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @SerializedName("books")
    val books: Int?,
    @SerializedName("children")
    val children: List<ChildrenResponse>?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String?
)