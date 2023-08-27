package com.skym.calculator.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.skym.calculator.presentation.calculator.CalculatorContent
import com.skym.calculator.presentation.converter.ConverterContent

@Composable
fun Container() {
    var selectedTabIndex by remember {mutableIntStateOf(0)}
    val tabs = listOf("Calculator", "Converter")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
    ) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ) {
            tabs.forEachIndexed { tabIndex, title ->
                Tab(
                    selected = selectedTabIndex == tabIndex,
                    onClick = { selectedTabIndex = tabIndex },
                    text = { Text(text = title) },
                    selectedContentColor = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.background(if (selectedTabIndex == tabIndex) MaterialTheme.colorScheme.primary else Color.Transparent)
                )
            }
        }
        when (selectedTabIndex) {
            0 -> CalculatorContent()
            1 -> ConverterContent()
        }
    }
}