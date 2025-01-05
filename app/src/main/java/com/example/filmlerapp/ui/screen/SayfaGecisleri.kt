package com.example.filmlerapp.ui.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.filmlerapp.data.entity.Filmler
import com.google.gson.Gson

@Composable
fun SayfaGecisleri(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "anasayfa"){
        composable("anasayfa"){
            Anasayfa(navController = navController)
        }
        composable(
            "detaySayfa/{film}",
            arguments = listOf(navArgument("film"){
                type = NavType.StringType
            })){
            val json = it.arguments?.getString("film")
            val nesne = Gson().fromJson(json,Filmler::class.java)
            DetaySayfa(gelenFilm = nesne)
        }
    }
}