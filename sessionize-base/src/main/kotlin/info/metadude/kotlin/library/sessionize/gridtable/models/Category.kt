package info.metadude.kotlin.library.sessionize.gridtable.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Category(

        val categoryItems: List<CategoryItem> = emptyList(),
        val id: Int = 0,
        val name: String = "",
        val sort: Int = 0

)
