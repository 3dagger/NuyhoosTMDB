package kr.dagger.nuyhoostmdb.core.model

data class Popular(
	val id: Long,
	val title: String,
	val posterPath: String,
	val overView: String,
	var isFavorite: Boolean = false
)
