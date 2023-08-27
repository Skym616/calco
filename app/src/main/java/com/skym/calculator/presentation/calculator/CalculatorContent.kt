package com.skym.calculator.presentation.calculator

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skym.calculator.R
import com.skym.calculator.presentation.common.CalculatorButton

val vm = CalculatorViewModel()

@Composable
fun CalculatorContent() {

    val state = vm.state

    Box(
        modifier = Modifier
            .padding(top = 56.dp)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                contentAlignment = Alignment.CenterEnd,
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(vertical = 4.dp, horizontal = 16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.clock),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                    Text(
                        text = "1,234",
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Right,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(300)
                    )
                }
            }

            Text(
                text = state.result,
                color = MaterialTheme.colorScheme.onPrimary,
                style = TextStyle(
                    fontSize = 64.sp,
                    lineHeight = 64.sp,
                    fontWeight = FontWeight(400),
                    textAlign = TextAlign.Right
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surface)
                    .height(48.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { vm.onAction(action = CalculatorAction.Delete) }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp)
                            .padding(start = 8.dp),
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }

                    Text(
                        text = if (state.operation == null) state.numberOne else state.numberOne+ state.operation.symbol +state.numberTwo,
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight(300),
                            lineHeight = 24.sp,
                            color = MaterialTheme.colorScheme.onSurface,
                            textAlign = TextAlign.Right
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 8.dp)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
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
                                shape = RoundedCornerShape(topStart = 8.dp),
                                onClick = { vm.onAction(action = CalculatorAction.Clear) }
                            )
                            CalculatorButton(
                                symbol = "+/-",
                                modifier = Modifier
                                    .weight(.1f),
                                containerColor = MaterialTheme.colorScheme.surfaceTint,
                                onClick = {}
                            )
                            CalculatorButton(
                                symbol = "%",
                                modifier = Modifier
                                    .weight(.1f),
                                containerColor = MaterialTheme.colorScheme.surfaceTint,
                                onClick = {}
                            )
                            CalculatorButton(
                                symbol = "÷",
                                modifier = Modifier
                                    .weight(.1f),
                                containerColor = MaterialTheme.colorScheme.primary,
                                shape = RoundedCornerShape(topEnd = 8.dp),
                                onClick = {
                                    vm.onAction(
                                        action = CalculatorAction.Operation(
                                            operation = CalculatorOperation.Divide
                                        )
                                    )
                                }
                            )
                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                            modifier = Modifier.weight(.1f)
                        ) {
                            CalculatorButton(
                                symbol = "7",
                                modifier = Modifier
                                    .weight(.1f),
                                onClick = { vm.onAction(action = CalculatorAction.Number("7")) }
                            )
                            CalculatorButton(
                                symbol = "8",
                                modifier = Modifier
                                    .weight(.1f),
                                onClick = { vm.onAction(action = CalculatorAction.Number("8")) }
                            )
                            CalculatorButton(
                                symbol = "9",
                                modifier = Modifier
                                    .weight(.1f),
                                onClick = { vm.onAction(action = CalculatorAction.Number("9")) }
                            )
                            CalculatorButton(
                                symbol = "×",
                                modifier = Modifier
                                    .weight(.1f),
                                containerColor = MaterialTheme.colorScheme.primary,
                                onClick = {
                                    vm.onAction(
                                        action = CalculatorAction.Operation(
                                            operation = CalculatorOperation.Multiply
                                        )
                                    )
                                }
                            )
                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                            modifier = Modifier.weight(.1f)
                        ) {
                            CalculatorButton(
                                symbol = "6",
                                modifier = Modifier
                                    .weight(.1f),
                                onClick = { vm.onAction(action = CalculatorAction.Number("6")) }
                            )
                            CalculatorButton(
                                symbol = "5",
                                modifier = Modifier
                                    .weight(.1f),
                                onClick = { vm.onAction(action = CalculatorAction.Number("5")) }
                            )
                            CalculatorButton(
                                symbol = "4",
                                modifier = Modifier
                                    .weight(.1f),
                                onClick = { vm.onAction(action = CalculatorAction.Number("4")) }
                            )
                            CalculatorButton(
                                symbol = "-",
                                modifier = Modifier
                                    .weight(.1f),
                                containerColor = MaterialTheme.colorScheme.primary,
                                onClick = {
                                    vm.onAction(
                                        action = CalculatorAction.Operation(
                                            operation = CalculatorOperation.Subtract
                                        )
                                    )
                                }
                            )
                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                            modifier = Modifier.weight(.1f)
                        ) {
                            CalculatorButton(
                                symbol = "3",
                                modifier = Modifier
                                    .weight(.1f),
                                onClick = { vm.onAction(action = CalculatorAction.Number("3")) }
                            )
                            CalculatorButton(
                                symbol = "2",
                                modifier = Modifier
                                    .weight(.1f),
                                onClick = { vm.onAction(action = CalculatorAction.Number("2")) }
                            )
                            CalculatorButton(
                                symbol = "1",
                                modifier = Modifier
                                    .weight(.1f),
                                onClick = { vm.onAction(action = CalculatorAction.Number("1")) }
                            )
                            CalculatorButton(
                                symbol = "+",
                                modifier = Modifier
                                    .weight(.1f),
                                containerColor = MaterialTheme.colorScheme.primary,
                                onClick = {
                                    vm.onAction(
                                        action = CalculatorAction.Operation(
                                            operation = CalculatorOperation.Add
                                        )
                                    )
                                }
                            )
                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                            modifier = Modifier.weight(.1f)
                        ) {
                            CalculatorButton(
                                symbol = "0",
                                modifier = Modifier
                                    .weight(.2f),
                                shape = RoundedCornerShape(bottomStart = 8.dp),
                                onClick = { vm.onAction(action = CalculatorAction.Number("0")) }

                            )
                            CalculatorButton(
                                symbol = ".",
                                modifier = Modifier
                                    .weight(.1f),
                                onClick = { }
                            )
                            CalculatorButton(
                                symbol = "=",
                                modifier = Modifier
                                    .weight(.1f),
                                containerColor = MaterialTheme.colorScheme.primary,
                                shape = RoundedCornerShape(bottomEnd = 8.dp),
                                onClick = { vm.onAction(action = CalculatorAction.Calculate) }
                            )
                        }
                    }
                }
            }
        }
    }
