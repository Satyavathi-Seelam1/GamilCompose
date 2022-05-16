package com.mutualmobile.gmailcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.mutualmobile.gmailcompose.R.string
import com.mutualmobile.gmailcompose.models.EmailListItem
import com.mutualmobile.gmailcompose.models.NavRoutes
import com.mutualmobile.gmailcompose.ui.theme.DividerColor

@Composable
fun EmailSetUp(navController: NavHostController) {

  val google = EmailListItem(R.drawable.google, stringResource(string.google))
  val outlook = EmailListItem(R.drawable.outlook, stringResource(string.outlook))
  val yahoo = EmailListItem(R.drawable.yahoo_mail, stringResource(string.yahoo))
  val exchange = EmailListItem(R.drawable.exchange, stringResource(string.exchange))
  val other = EmailListItem(R.drawable.other_email, stringResource(string.other))

  val emailsList: List<EmailListItem> = mutableListOf(google, outlook, yahoo, exchange, other)
  EmailSetUpScreen(emailsList = emailsList) {
    navController.navigate(NavRoutes.SignIn.route)
  }
}

@Composable
fun EmailSetUpScreen(
  emailsList: List<EmailListItem>,
  onClick: () -> Unit
) {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(16.dp)
  ) {
    HeaderView()
    Spacer(modifier = Modifier.height(36.dp))
    EmailList(emailsList, onClick)
  }
}

@Composable
fun HeaderView() {
  Column() {
    Spacer(modifier = Modifier.height(36.dp))
    Image(
      modifier = Modifier.size(width = 24.dp, 24.dp),
      painter = painterResource(id = R.drawable.gmail_logo),
      contentDescription = ""
    )
    Spacer(modifier = Modifier.height(12.dp))
    Text(
      text = stringResource(string.set_up_email), fontSize = 28.sp
    )
  }
}

@Composable
fun EmailList(
  emailsList: List<EmailListItem>,
  onClick: () -> Unit
) {
  Divider(modifier = Modifier.height(1.dp), color = DividerColor)
  LazyColumn(
    modifier = Modifier.fillMaxWidth(),
    verticalArrangement = Arrangement.Center
  ) {
    items(emailsList) { emailsListItem ->
      EmailItem(emailListItem = emailsListItem, onClick)
    }
  }
}

@Composable
fun EmailItem(
  emailListItem: EmailListItem,
  onClick: () -> Unit
) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .height(50.dp)
      .clickable { onClick() }, verticalAlignment = Alignment.CenterVertically
  ) {
    Image(
      modifier = Modifier.size(width = 24.dp, 24.dp),
      painter = painterResource(id = emailListItem.drawableId),
      contentDescription = ""
    )
    Spacer(modifier = Modifier.width(24.dp))
    Text(
      text = emailListItem.name, fontSize = 16.sp
    )
  }
  Divider(modifier = Modifier.height(1.dp), color = DividerColor)
}

