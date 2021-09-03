package kt.mobile.helion_krzysztof_terelak2.data.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Category(
    val books: Int?,
    val children: @RawValue List<Children>?,
    val id: Int?,
    val name: String?,
):Parcelable
