package com.example.naviagtionsample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FirstScreen(
    modifier: Modifier, paddingValues: PaddingValues,
    navigationToSecondScreen: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var name = remember { mutableStateOf("") }
        Text("You are on the first screen", fontSize = 20.sp)
        Spacer(modifier = modifier.height(20.dp))
        OutlinedTextField(
            value = name.value,
            onValueChange = {
                name.value = it
            })
        Spacer(modifier = modifier.height(20.dp))
        Text("Your name is ${name.value}")

        Button(onClick = {
            navigationToSecondScreen()
        }) {
            Text("Move to Next Screen")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun FirstPreview() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        FirstScreen(modifier = Modifier, paddingValues = innerPadding, {})
    }

}