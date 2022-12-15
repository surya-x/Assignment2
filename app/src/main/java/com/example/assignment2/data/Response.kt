package com.example.assignment2.data

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("pronunciation")
	val pronunciation: String? = null,

	@field:SerializedName("definitions")
	val definitions: List<DefinitionsItem?>? = null,

	@field:SerializedName("word")
	val word: String? = null
)

data class DefinitionsItem(

	@field:SerializedName("emoji")
	val emoji: String? = null,

	@field:SerializedName("image_url")
	val imageUrl: Any? = null,

	@field:SerializedName("definition")
	val definition: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("example")
	val example: String? = null
)
