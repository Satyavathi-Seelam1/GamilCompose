package com.mutualmobile.gmailcompose

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun ClickableText(
  text: String,
  onClick: () -> Unit = {},
  fontSize: TextUnit = 14.sp
) {
  androidx.compose.foundation.text.ClickableText(
    text = buildAnnotatedString {
      withStyle(style = SpanStyle(color = Color.Blue)) {
        append(text = text)
      }
    },
    style = TextStyle(fontSize = fontSize),
    onClick = {
      onClick()
    }
  )
}