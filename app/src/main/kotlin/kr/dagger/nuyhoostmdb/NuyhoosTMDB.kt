package kr.dagger.nuyhoostmdb

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NuyhoosTMDB : Application() {

	override fun onCreate() {
		super.onCreate()
		initLogger()
	}

	private fun initLogger() {
		val formatStrategy = PrettyFormatStrategy.newBuilder()
			.showThreadInfo(true)
			.methodCount(2)
			.methodOffset(5)
			.tag("leeam")
			.build()

		Logger.addLogAdapter(object : AndroidLogAdapter(formatStrategy) {
			override fun isLoggable(priority: Int, tag: String?): Boolean {
				return BuildConfig.DEBUG
			}
		})
	}
}