package kr.dagger.composetmdb.data.remote

import kr.dagger.composetmdb.data.model.response.DetailResponse
import kr.dagger.composetmdb.data.model.response.PopularResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

	@GET("/3/movie/now_playing?page=1")
	suspend fun getPopular(
		@Query("language") language: String = "kr-KR",
		@Query("page") page: Int
	): PopularResponse

	@GET("/3/movie/{id}?language=kr-KR")
	suspend fun getDetail(@Path(value = "id") id: Int): DetailResponse
}