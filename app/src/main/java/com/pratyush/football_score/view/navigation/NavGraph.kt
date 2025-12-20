package com.pratyush.football_score.view.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pratyush.football_score.view.screens.DetailsScreen
import com.pratyush.football_score.view.screens.HomeScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoutes.HOME
    ) {

        composable(NavRoutes.HOME) {
            HomeScreen(
                onTeamClick = { teamName ->
                    navController.navigate("${NavRoutes.DETAILS}/$teamName")
                }
            )
        }

        composable(
            route = "${NavRoutes.DETAILS}/{teamName}",
            arguments = listOf(
                navArgument("teamName") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val teamName = backStackEntry.arguments?.getString("teamName")!!
            DetailsScreen(
                onBack = { navController.popBackStack() }
            )
        }
    }
}