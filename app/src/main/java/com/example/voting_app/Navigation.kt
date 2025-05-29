package com.example.voting_app

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.voting_app.screen.HomeScreen
import com.example.voting_app.screen.LoginScreen
import com.example.voting_app.screen.OtpScreen
import com.example.voting_app.screen.ProfileScreen
import com.example.voting_app.screen.SchemeScreen
import com.example.voting_app.screen.SignupScreen
import com.example.voting_app.screen.UserDataStore

@Composable
fun AppNavigation(userDataStore: UserDataStore,modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController, userDataStore) }
        composable("signup") { SignupScreen(navController) }
        composable("otp") { OtpScreen(navController, userDataStore) }
        composable("home") { HomeScreen() }
        composable("scheme") { SchemeScreen() }
        composable("profile") { ProfileScreen() }
    }
}
