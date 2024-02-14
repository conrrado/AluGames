package com.conrradocamacho.alugames.main

import com.conrradocamacho.alugames.data.Database
import com.conrradocamacho.alugames.model.Game

fun main() {
    val gameList: List<Game> = Database.getGames()
    println(gameList)
}