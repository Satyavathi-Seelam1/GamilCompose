package com.mutualmobile.gmailcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.mutualmobile.gmailcompose.R.drawable
import com.mutualmobile.gmailcompose.R.string
import com.mutualmobile.gmailcompose.models.NavRoutes

@Composable
fun SignIn(navController: NavHostController) {
  SignInScreen() {
    navController.navigate(NavRoutes.Password.route)
  }
}

@Composable
fun SignInScreen(onClick: () -> Unit) {
  var text by rememberSaveable { mutableStateOf("") }
  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Spacer(modifier = Modifier.height(24.dp))
    Image(
      modifier = Modifier.size(width = 100.dp, 100.dp),
      painter = painterResource(id = drawable.google_name),
      contentDescription = ""
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(
      text = stringResource(string.sign_in), fontSize = 24.sp
    )
    Row(Modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
      Text(text = stringResource(string.with_google_account))
      ClickableText(text = stringResource(string.learn_more), fontSize = 14.sp)
    }

    Spacer(modifier = Modifier.height(16.dp))
    OutlinedTextField(modifier = Modifier
      .fillMaxWidth()
      .padding(10.dp, 10.dp, 10.dp, 0.dp),
      value = text, onValueChange = { text = it }, placeholder = {
      Text(
        stringResource(string.enter_email)
      )
    })

    Spacer(modifier = Modifier.height(12.dp))
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp, 0.dp, 16.dp, 0.dp), horizontalAlignment = Alignment.Start
    ) {
      ClickableText(text = stringResource(string.forgot_email), fontSize = 15.sp)

      Spacer(modifier = Modifier.height(28.dp))

      ClickableText(text = stringResource(string.create_account), fontSize = 15.sp)
    }

    Column(
      Modifier
        .fillMaxWidth()
        .weight(1f)
        .padding(16.dp), verticalArrangement = Arrangement.Bottom,
      horizontalAlignment = Alignment.End
    ) {
      Button(onClick = { onClick() }) {
        Text(text = stringResource(string.next))
      }
    }

  }
}


