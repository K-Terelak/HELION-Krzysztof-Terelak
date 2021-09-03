package kt.mobile.helion_krzysztof_terelak2.data.remote.response


import com.google.gson.annotations.SerializedName

data class ChildrenResponse(
    @SerializedName("books")
    val books: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?
)