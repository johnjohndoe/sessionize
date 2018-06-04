package info.metadude.kotlin.library.sessionize.gridtable.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CategoryItem(

        val id: Int = 0,
        val name: String = ""

)
