package com.conrradocamacho.alugames.main

import com.conrradocamacho.alugames.data.Database
import com.conrradocamacho.alugames.data.GameDAO
import com.conrradocamacho.alugames.data.GamerDAO
import com.conrradocamacho.alugames.model.Game
import com.conrradocamacho.alugames.model.Gamer
import java.math.BigDecimal

fun main() {
    val game = Game("The Last of Us Part I",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554",
        BigDecimal(5.99),
        "Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito.")
    val game2 = Game("Dandara",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/612390/header.jpg?t=1674055293",
        BigDecimal(9.99),
        "Um jogo de plataforma e ação com elementos de metroidvania, onde você controla a heroína Dandara em sua luta para libertar um mundo repleto de opressão e tirania.")

    val manager = Database.getEntityManager()
    val gameDAO = GameDAO(manager)
//    gameDAO.addGame(game)

    val gameList: List<Game> = gameDAO.getGames()
    println("\n=============== Games ===============\n")
    println(gameList)

    val gamer1 = Gamer("Maria", "maria@email.com", "10/10/1990", "ursinho")
    val gamerDAO = GamerDAO(manager)
//    gamerDAO.addGamer(gamer1)

    val gamerList = gamerDAO.getGamers()
    println("\n=============== Gamers ===============\n")
    println(gamerList)

    manager.close()
}