package com.mutualmobile.gmailcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import com.google.accompanist.drawablepainter.rememberDrawablePainter
import com.mutualmobile.gmailcompose.R.string
import com.mutualmobile.gmailcompose.models.NavRoutes
import com.mutualmobile.gmailcompose.ui.theme.DividerColor
import com.mutualmobile.gmailcompose.ui.theme.HeaderColor

@Composable
fun AddEmail(navController: NavHostController) {

  Column(modifier = Modifier.fillMaxSize()) {
    BlueHeader()
    Column(Modifier.padding(10.dp)) {
      Text(text = stringResource(string.add_email_desc))
      ClickableText(text = stringResource(string.learn_more), fontSize = 15.sp)
    }
    Divider(color = DividerColor, thickness = 1.dp)
    AddButton {
      navController.navigate(NavRoutes.EmailSetup.route)
    }
    Column(
      Modifier
        .fillMaxWidth()
        .weight(1f), horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Bottom
    ) {
      BottomLayout{
        navController.navigate(NavRoutes.EmailSetup.route)
      }
    }
  }
}

@Composable
fun AddButton(onClick: () -> Unit) {
  Spacer(modifier = Modifier.height(8.dp))
  Row(
    Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Image(
      modifier = Modifier.size(width = 30.dp, 30.dp),
      painter = painterResource(id = R.drawable.add),
      contentDescription = ""
    )
    Spacer(modifier = Modifier.width(12.dp))
    ClickableText(text = stringResource(string.add_email), onClick = onClick, fontSize = 16.sp)
  }
}

@Composable
fun BlueHeader() {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .height(200.dp)
      .background(color = HeaderColor),
    horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.Bottom
  ) {
    Image(
      modifier = Modifier
        .size(width = 200.dp, 200.dp)
        .offset(y = 13.dp),
      painter = painterResource(id = R.drawable.add_email),
      contentDescription = ""
    )
  }
}

@Composable
fun BottomLayout(onClick: () -> Unit) {
  Box(
    modifier = Modifier
      .fillMaxWidth()
      .height(50.dp).clickable { onClick() }, contentAlignment = Alignment.Center
  ) {
    Image(
      rememberDrawablePainter(
        drawable = ContextCompat.getDrawable(LocalContext.current, R.drawable.rectangle)
      ),
      contentDescription = "Background",
      modifier = Modifier.matchParentSize(),
      contentScale = ContentScale.FillBounds
    )

    Text(text = stringResource(string.take_me_gmail))
  }
}

