package com.example.naviagtionsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.naviagtionsample.ui.theme.NaviagtionSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NaviagtionSampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp(modifier = Modifier, innerPadding)
                }
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier, paddingValues: PaddingValues) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "firstscreen"){
        composable(route = "firstscreen"){
            FirstScreen(modifier = Modifier, paddingValues) {
                navController.navigate("secondscreen")
            }
        }
        composable(route = "secondscreen"){
            SecondScreen(modifier = Modifier, paddingValues) {
                navController.navigate("firstscreen")
            }
        }

    }
}