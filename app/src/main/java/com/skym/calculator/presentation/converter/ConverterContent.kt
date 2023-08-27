package com.skym.calculator.presentation.converter


import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skym.calculator.R
import com.skym.calculator.presentation.common.CalculatorButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConverterContent() {

    Box(
        modifier = Modifier
            .padding(top = 32.dp)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center)
            ) {
                TextButton(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.textButtonColors(contentColor = MaterialTheme.colorScheme.onSurface)
                ) {
                    Text(
                        text = "Length",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight(400)
                        )
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.polygon_1),
                        contentDescription = "More"
                    )
                }
                DropdownMenu(
                    expanded = false,
                    onDismissRequest = { false }
                ) {
                    DropdownMenuItem(
                        text = { Text("Load") },
                        onClick = { }
                    )
                    DropdownMenuItem(
                        text = { Text("Save") },
                        onClick = { }
                    )
                }
            }

            Row() {
                TextField(
                    value = "10",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(.8f),
                    maxLines = 1,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        unfocusedIndicatorColor = MaterialTheme.colorScheme.onSurface
                    )
                )
                Box(
                    modifier = Modifier
                ) {
                    TextButton(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.textButtonColors(contentColor = MaterialTheme.colorScheme.onSurface)
                    ) {
                        Text(
                            text = "km",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight(400)
                            )
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.polygon_1),
                            contentDescription = "More"
                        )
                    }
                    DropdownMenu(
                        expanded = false,
                        onDismissRequest = { false }
                    ) {
                        DropdownMenuItem(
                            text = { Text("Load") },
                            onClick = { }
                        )
                        DropdownMenuItem(
                            text = { Text("Save") },
                            onClick = { }
                        )
                    }
                }
            }

            Row() {
                TextField(
                    value = "10",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(.8f),
                    maxLines = 1,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        unfocusedIndicatorColor = MaterialTheme.colorScheme.onSurface
                    )
                )
                Box(
                    modifier = Modifier
                ) {
                    TextButton(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.textButtonColors(contentColor = MaterialTheme.colorScheme.onSurface)
                    ) {
                        Text(
                            text = "m",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight(400)
                            )
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.polygon_1),
                            contentDescription = "More"
                        )
                    }
                    DropdownMenu(
                        expanded = false,
                        onDismissRequest = { false }
                    ) {
                        DropdownMenuItem(
                            text = { Text("Load") },
                            onClick = { }
                        )
                        DropdownMenuItem(
                            text = { Text("Save") },
                            onClick = { }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(40.dp))
            Box(
                contentAlignment = Alignment.BottomCenter,
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        modifier = Modifier.weight(.1f)
                    ) {
                        CalculatorButton(
                            symbol = "AC",
                            modifier = Modifier
                                .weight(.1f),
                            containerColor = MaterialTheme.colorScheme.surfaceTint,
                            shape = RoundedCornerShape(topStart = 8.dp)
                        )
                        CalculatorButton(
                            symbol = "+/-",
                            modifier = Modifier
                                .weight(.1f),
                            containerColor = MaterialTheme.colorScheme.surfaceTint,
                            icon = R.drawable.exchange
                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        modifier = Modifier.weight(.1f)
                    ) {
                        CalculatorButton(
                            symbol = "7",
                            modifier = Modifier
                                .weight(.1f)
                        )
                        CalculatorButton(
                            symbol = "8",
                            modifier = Modifier
                                .weight(.1f)
                        )
                        CalculatorButton(
                            symbol = "9",
                            modifier = Modifier
                                .weight(.1f)
                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        modifier = Modifier.weight(.1f)
                    ) {
                        CalculatorButton(
                            symbol = "6",
                            modifier = Modifier
                                .weight(.1f)
                        )
                        CalculatorButton(
                            symbol = "5",
                            modifier = Modifier
                                .weight(.1f)
                        )
                        CalculatorButton(
                            symbol = "4",
                            modifier = Modifier
                                .weight(.1f)
                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        modifier = Modifier.weight(.1f)
                    ) {
                        CalculatorButton(
                            symbol = "3",
                            modifier = Modifier
                                .weight(.1f)
                        )
                        CalculatorButton(
                            symbol = "2",
                            modifier = Modifier
                                .weight(.1f)
                        )
                        CalculatorButton(
                            symbol = "1",
                            modifier = Modifier
                                .weight(.1f)
                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        modifier = Modifier.weight(.1f)
                    ) {
                        CalculatorButton(
                            symbol = ".",
                            modifier = Modifier
                                .weight(.1f),
                            shape = RoundedCornerShape(bottomStart = 8.dp)
                        )
                        CalculatorButton(
                            symbol = "0",
                            modifier = Modifier
                                .weight(.1f)
                        )
                        CalculatorButton(
                            symbol = "=",
                            modifier = Modifier
                                .weight(.1f),
                            shape = RoundedCornerShape(bottomEnd = 8.dp),
                            icon = R.drawable.polygon
                        )
                    }
                }
            }
        }
    }
}