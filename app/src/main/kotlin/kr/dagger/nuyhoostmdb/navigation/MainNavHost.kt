package kr.dagger.nuyhoostmdb.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navOptions
import com.orhanobut.logger.Logger
import kr.dagger.nuyhoostmdb.feature.bookmark.BookmarkRoute
import kr.dagger.nuyhoostmdb.feature.bookmark.BookmarkScreen
import kr.dagger.nuyhoostmdb.feature.home.HomeRoute
import kr.dagger.nuyhoostmdb.feature.search.SearchScreen
import kr.dagger.nuyhoostmdb.feature.setting.SettingScreen
import kr.dagger.nuyhoostmdb.movie.MovieDetailRoute
import kr.dagger.nuyhoostmdb.movie.MovieDetailScreen

@Composable
fun MainNavHost(
	navController: NavHostController,
	modifier: Modifier = Modifier,
	innerPadding: PaddingValues
) {
	NavHost(
		navController = navController,
		startDestination = BottomBarScreen.Home.route,
		modifier = modifier.padding(innerPadding)
	) {

		composable(BottomBarScreen.Home.route) {
			HomeRoute(
				modifier = modifier.fillMaxSize(),
				navigateToDetail = { id ->
					navController.navigate(
						GeneralScreen.DetailMovie.createRoute(id)
					)
				}
			)
		}

		composable(BottomBarScreen.Bookmark.route) {
			BookmarkRoute(
				modifier = modifier.fillMaxSize(),
				navigateToDetail = { id ->
					navController.navigate(GeneralScreen.DetailMovie.createRoute(id))
				}
			)
		}

		composable(BottomBarScreen.Search.route) {
			SearchScreen(
				modifier = modifier.fillMaxSize(),
			) {}
		}

		composable(BottomBarScreen.Setting.route) {
			SettingScreen(
				modifier = modifier.fillMaxSize()
			) {}
		}

		composable(
			route = GeneralScreen.DetailMovie.route,
			arguments = listOf(navArgument("id") { type = NavType.IntType })
		) {
			MovieDetailRoute(
				modifier = modifier.fillMaxSize(),
				navigateBack = { navController.navigateUp() }
			)
		}
	}
}