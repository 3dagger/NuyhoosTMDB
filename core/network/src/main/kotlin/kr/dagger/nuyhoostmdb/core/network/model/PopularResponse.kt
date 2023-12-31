package kr.dagger.nuyhoostmdb.core.network.model

import com.google.gson.annotations.SerializedName

data class PopularResponse(
	@SerializedName("results")
	val results: List<PopularItemResponse>
)
