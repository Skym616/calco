package com.skym.calculator.presentation.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skym.calculator.R

@Composable
fun CalculatorButton(
    modifier: Modifier = Modifier,
    symbol: String,
    shape: Shape = RectangleShape,
    containerColor: Color = MaterialTheme.colorScheme.inverseSurface,
    icon: Int? = null,
    onClick: () -> Unit ={}
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .then(modifier)
            .fillMaxSize()
    ) {
        Button(
            onClick = { onClick() },
            shape = shape,
            modifier = Modifier.fillMaxSize(),
            elevation = ButtonDefaults.buttonElevation(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor)
        ) {
            if (icon != null) {
                Icon(painter = painterResource(id = icon), contentDescription = null)
            } else {
                Text(
                    text = symbol,
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.onSurface,
                        fontSize = 28.sp,
                        fontWeight = FontWeight(400)
                    )
                )
            }

        }
    }
}