package com.conrradocamacho.alugames.main

import com.conrradocamacho.alugames.data.Database
import com.conrradocamacho.alugames.data.GameDAO
import com.conrradocamacho.alugames.model.Game
import java.math.BigDecimal

fun main() {
    val game = Game("The Last of Us Part I",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554",
        BigDecimal(5.99),
        "Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito.")
    val gameDAO = GameDAO()
//    gameDAO.addGame(game)


    val gameList: List<Game> = gameDAO.getGames()
    println(gameList)
}