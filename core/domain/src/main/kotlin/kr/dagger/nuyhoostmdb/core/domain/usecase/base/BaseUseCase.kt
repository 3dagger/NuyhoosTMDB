package kr.dagger.nuyhoostmdb.core.domain.usecase.base

abstract class BaseUseCase<in Params, out T> {

	abstract fun execute(params: Params): T
}