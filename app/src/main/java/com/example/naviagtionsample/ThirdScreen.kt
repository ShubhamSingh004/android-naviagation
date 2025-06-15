package com.example.naviagtionsample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun ThirdScreen(paddingValues: PaddingValues, age: String, navigateToFirstScreen:()->Unit){
    Column(modifier = Modifier
        .padding(paddingValues)
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Third Screen", fontSize = 26.sp)
        Text("Your age is $age")
        Button(onClick = {
            navigateToFirstScreen()
        }) {
            Text("Go to first Screen")
        }
    }
}