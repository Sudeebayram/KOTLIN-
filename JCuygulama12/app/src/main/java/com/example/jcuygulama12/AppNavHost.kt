package com.example.jcuygulama12

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItems.Login.route

) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItems.Login.route) {
            LoginScreen(navController)


        }
        composable("${NavigationItems.Register.route}/{nameSurname}") {
            backStackEntry ->
            val nameSurname = backStackEntry.arguments?.getString("nameSurname")?:""
            RegisterScreen(navController , nameSurname = nameSurname)

        }
    }
}
