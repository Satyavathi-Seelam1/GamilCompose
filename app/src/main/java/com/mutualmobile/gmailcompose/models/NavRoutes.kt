package com.mutualmobile.gmailcompose.models

sealed class NavRoutes(val route: String){
   object Welcome : NavRoutes("WelcomeScreen")
   object AddEmail : NavRoutes("AddEmailScreen")
   object EmailSetup : NavRoutes("EmailSetupScreen")
   object SignIn : NavRoutes("SignInScreen")
   object Password: NavRoutes("PasswordScreen")
}
