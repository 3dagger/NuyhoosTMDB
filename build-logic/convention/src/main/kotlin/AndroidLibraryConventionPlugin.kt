import com.android.build.api.variant.LibraryAndroidComponentsExtension
import com.android.build.gradle.LibraryExtension
import kr.dagger.nuyhoostmdb.configureKotlinAndroid
import kr.dagger.nuyhoostmdb.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

class AndroidLibraryConventionPlugin : Plugin<Project> {

	override fun apply(target: Project) {
		with(target) {
			with(pluginManager) {
				apply("com.android.library")
				apply("org.jetbrains.kotlin.android")
			}

			extensions.configure<LibraryExtension> {
				configureKotlinAndroid(this)
				defaultConfig.targetSdk = 34
			}
			dependencies {
				add("implementation", libs.findLibrary("logger").get())
				add("testImplementation", kotlin("test"))
				add("androidTestImplementation", kotlin("test"))
			}
		}
	}
}