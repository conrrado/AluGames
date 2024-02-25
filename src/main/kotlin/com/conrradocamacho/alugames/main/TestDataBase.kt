package com.conrradocamacho.alugames.main

import com.conrradocamacho.alugames.data.Database
import com.conrradocamacho.alugames.data.GameDAO
import com.conrradocamacho.alugames.data.GamerDAO
import com.conrradocamacho.alugames.model.Game
import com.conrradocamacho.alugames.model.Gamer
import java.math.BigDecimal
import javax.persistence.EntityManager

fun main() {
    val manager = Database.getEntityManager()
    testGame(manager)
    testGamer(manager)
    manager.close()
}

fun testGame(manager: EntityManager) {
    val game = Game("The Last of Us Part I",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554",
        BigDecimal(5.99),
        "Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito.")
    val game2 = Game("Dandara",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/612390/header.jpg?t=1674055293",
        BigDecimal(9.99),
        "Um jogo de plataforma e ação com elementos de metroidvania, onde você controla a heroína Dandara em sua luta para libertar um mundo repleto de opressão e tirania.")

    val gameDAO = GameDAO(manager)
//    gameDAO.add(game)

//    val gameFromDatabase = gameDAO.getById(3)
//    println("\n Game from database:\n$gameFromDatabase")

//    gameDAO.delete(3)

    val gameList = gameDAO.getList()
    println("\n=============== Games ===============\n")
    println(gameList)

    val lastGame = gameList.last()
    lastGame.price = BigDecimal(52.0)
    gameDAO.alter(lastGame)

    val lastGameFromDatabase = gameDAO.getById(lastGame.id)
    println("\n Last Game from database:\n$lastGameFromDatabase")

}

fun testGamer(manager: EntityManager) {
    val gamer1 = Gamer("Maria", "maria@email.com", "10/10/1990", "ursinho")
    val gamerDAO = GamerDAO(manager)
//    gamerDAO.add(gamer1)

//    val gamerFromDatabase = gamerDAO.getById(4)
//    println("\n Gamer from database:\n$gamerFromDatabase")

//    gamerDAO.delete(4)

    val gamerList = gamerDAO.getList()
    println("\n=============== Gamers ===============\n")
    println(gamerList)

    val lastGamer = gamerList.last()
    lastGamer.email = "${lastGamer.name}123@test.com"
    gamerDAO.alter(lastGamer)

    val lastGamerFromDatabase = gamerDAO.getById(lastGamer.id)
    println("\n Last Gamer from database:\n$lastGamerFromDatabase")

}
