package com.example.datastoreapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.datastoreapp.dataStore.StoreBoarding
import com.example.datastoreapp.dataStore.StoreDarkMode
import com.example.datastoreapp.onBoardViews.MainOnBoarding
import com.example.datastoreapp.views.HomeView
import com.example.datastoreapp.views.SplashScreen

@Composable
fun NavManager(darkModeStore: StoreDarkMode, darkMode: Boolean){
    val context = LocalContext.current
    val dataStore = StoreBoarding(context)
    val store = dataStore.getBoarding.collectAsState(initial = false)
    
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = if (store.value) "Home" else "Splash"){
        composable("OnBoarding"){
            MainOnBoarding(navController,dataStore)
        }
        composable("Home"){
            HomeView(navController,darkModeStore,darkMode)
        }
        composable("Splash"){
            SplashScreen(navController,store.value)
        }
    }
}