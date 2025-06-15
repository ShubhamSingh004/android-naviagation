package com.example.naviagtionsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
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
                    MyApp(innerPadding)
                }
            }
        }
    }
}

@Composable
fun MyApp(paddingValues: PaddingValues) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "firstscreen"){
        composable(route = "firstscreen"){
            FirstScreen(modifier = Modifier, paddingValues) { name->
                navController.navigate("secondscreen/$name")
            }
        }

        composable(route = "secondscreen/{name}"){
            val name = it.arguments?.getString("name") ?: "No Name"
            SecondScreen(
                modifier = Modifier, paddingValues,
                name = name,
                navigateToFirstScreen = {navController.navigate("firstscreen")},
                navigateToThirdScreen = {navController.navigate("thirdscreen")}

            )
        }

        composable(route = "thirdscreen") {
            ThirdScreen(paddingValues) {
                navController.navigate("firstscreen")
            }
        }

    }
}