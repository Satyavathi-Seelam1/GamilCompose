package com.mutualmobile.gmailcompose

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.mutualmobile.gmailcompose.models.NavRoutes
import com.mutualmobile.gmailcompose.models.NavRoutes.EmailSetup
import com.mutualmobile.gmailcompose.models.NavRoutes.Welcome

@ExperimentalPagerApi
@Composable
fun GmailNavigation(){
  val navController = rememberNavController()

  NavHost(
    navController = navController,
    startDestination = Welcome.route,
  ) {
    composable(Welcome.route) {
      WelcomeScreen(navController = navController)
    }

    composable(NavRoutes.AddEmail.route) {
      AddEmail(navController = navController)
    }

    composable(EmailSetup.route) {
      EmailSetUp(navController = navController)
    }

    composable(NavRoutes.SignIn.route) {
      SignIn(navController = navController)
    }

    composable(NavRoutes.Password.route) {
      Password(navController = navController)
    }
  }
}