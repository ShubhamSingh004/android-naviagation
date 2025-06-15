package com.example.naviagtionsample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SecondScreen(
    modifier: Modifier,
    paddingValues: PaddingValues,
    name: String,
    navigateToFirstScreen: () -> Unit,
    navigateToThirdScreen: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("$name, you are on the Second screen", fontSize = 20.sp)
        Spacer(modifier = modifier.height(20.dp))
        Spacer(modifier = modifier.height(20.dp))

        Button(onClick = {
            navigateToFirstScreen()
        }) {
            Text("Move to First Screen")
        }

        Button(onClick = {
            navigateToThirdScreen()
        }) {
            Text("Move to Third Screen")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SecondPreview() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        SecondScreen(
            modifier = Modifier,
            name = "Shubham",
            paddingValues = innerPadding,
            navigateToFirstScreen = {},
            navigateToThirdScreen = {}
        )
    }

}