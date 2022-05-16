package com.mutualmobile.gmailcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign.Companion
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.mutualmobile.gmailcompose.R.string
import com.mutualmobile.gmailcompose.models.NavRoutes
import com.mutualmobile.gmailcompose.ui.theme.DividerColor
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun WelcomeScreen(navController: NavHostController) {
  val pagerState = rememberPagerState()

  HorizontalPager(count = 2, state = pagerState) { page ->
    PageLoad(pagerState.currentPage, onDoneClick = {
      navController.navigate(NavRoutes.AddEmail.route)
    },pagerState)
  }
}

@ExperimentalPagerApi
@Composable
fun ArrowClick(pagerState: PagerState) {
  LaunchedEffect(key1 = 1) {
    pagerState.scrollToPage(1, 0f)
  }
}

@ExperimentalPagerApi
@Composable
fun PageLoad(
  index: Int,
  onDoneClick: () -> Unit,
  pagerState: PagerState
) {
  Column(
    modifier = Modifier
      .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .weight(3f), horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center
    ) {
      Logo(index)
    }
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .weight(1f)
        .padding(26.dp), horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center
    ) {
      WelcomeTexts(index)
    }

    Column(
      Modifier
        .fillMaxWidth()
        .weight(1f)
        .padding(bottom = 4.dp), horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Bottom
    ) {
      BottomLayout(index = index, onDoneClick,pagerState)
    }

  }
}

@ExperimentalPagerApi
@Composable
fun Logo(index: Int) {
  val drawableId = if (index == 0) R.drawable.gmail_logo else R.drawable.welcome_2_image
  Image(
    modifier = Modifier.size(width = 150.dp, 150.dp), painter = painterResource(id = drawableId),
    contentDescription = ""
  )
}

@ExperimentalPagerApi
@Composable
fun WelcomeTexts(index: Int) {
  if (index == 0) {
    Text(text = stringResource(string.welcome_title), fontSize = 20.sp)
    Spacer(modifier = Modifier.height(height = 10.dp))
    Text(text = stringResource(string.welcome_1_desc), fontSize = 16.sp)
  } else {
    Text(
      text = stringResource(string.welcome_2_desc),
      fontSize = 18.sp, textAlign = Companion.Center
    )
  }
}

@ExperimentalPagerApi
@Composable
fun BottomLayout(
  index: Int,
  onDoneClick: () -> Unit, pagerState: PagerState
) {
  Divider(color = DividerColor, thickness = 1.dp)
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .height(50.dp)
      .padding(8.dp), horizontalArrangement = Arrangement.SpaceAround,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Text(text = stringResource(string.skip))
    DotsIndicator(
      totalDots = 2,
      selectedIndex = index,
      selectedColor = Color.Black,
      unSelectedColor = Color.LightGray
    )
    if (index == 0) {
      val scope = rememberCoroutineScope()
      Image(
        modifier = Modifier
          .size(width = 20.dp, 20.dp)
          .clickable {
            scope.launch {
              pagerState.scrollToPage(1)
            }
          }, painter = painterResource(id = R.drawable.right_arrow_icon),
        contentDescription = ""
      )
    } else {
      Text(text = stringResource(string.done), modifier = Modifier.clickable { onDoneClick() })
    }
  }
  Divider(color = DividerColor, thickness = 1.dp)
}

@Composable
fun DotsIndicator(
  totalDots: Int,
  selectedIndex: Int,
  selectedColor: Color,
  unSelectedColor: Color,
) {

  LazyRow(
    modifier = Modifier
      .wrapContentWidth()
      .wrapContentHeight()

  ) {

    items(totalDots) { index ->
      if (index == selectedIndex) {
        Box(
          modifier = Modifier
            .size(8.dp)
            .clip(CircleShape)
            .background(selectedColor)
        )
      } else {
        Box(
          modifier = Modifier
            .size(8.dp)
            .clip(CircleShape)
            .background(unSelectedColor)
        )
      }

      if (index != totalDots - 1) {
        Spacer(modifier = Modifier.padding(horizontal = 2.dp))
      }
    }
  }
}


