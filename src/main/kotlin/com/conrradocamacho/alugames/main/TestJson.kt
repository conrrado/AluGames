package com.conrradocamacho.alugames.main

import com.conrradocamacho.alugames.model.RentalPeriod
import com.conrradocamacho.alugames.model.SubscriptionPlan
import com.conrradocamacho.alugames.services.ConsumeApi
import com.google.gson.GsonBuilder
import java.io.File
import java.math.BigDecimal
import java.time.LocalDate

fun main() {
    val api = ConsumeApi()
    val gamerList = api.getGamerList()
    val gameList = api.getGameList()
//    println(gamerList)
//    println(game)

    val gamerCaroline = gamerList.get(3)

    val gameResidentVillage = gameList.get(10)
    val gameSpiderMan = gameList.get(13)
    val gameTheLastOfUs = gameList.get(2)
    val gameGodOfWar = gameList.get(7)
    val gameDandara = gameList.get(5)
    val gameAssassins = gameList.get(4)
    val gameCyber = gameList.get(6)
    val gameGod = gameList.get(7)
    val gameSkyrim = gameList.get(18)

//    println(gamerCaroline)
//    println(gameResidentVillage)

    val rentalPeriod1 = RentalPeriod(LocalDate.now(), LocalDate.now().plusDays(7))
    val rentalPeriod2 = RentalPeriod(LocalDate.now(), LocalDate.now().plusDays(3))
    val rentalPeriod3 = RentalPeriod(LocalDate.now(), LocalDate.now().plusDays(10))
    val rentalPeriod4 = RentalPeriod(LocalDate.now().plusMonths(1), LocalDate.now().plusMonths(1).plusDays(10))

    gamerCaroline.rentalGame(gameResidentVillage, rentalPeriod1)
    gamerCaroline.rentalGame(gameSpiderMan, rentalPeriod2)
    gamerCaroline.rentalGame(gameTheLastOfUs, rentalPeriod3)
    gamerCaroline.rentalGame(gameGodOfWar, rentalPeriod4)
    println(gamerCaroline.rentedGames)

    println(gamerCaroline.getRentedGameListByMonth(LocalDate.now().month + 1))

    val gamerCamila = gamerList.get(5)
    gamerCamila.plan = SubscriptionPlan("SILVER", BigDecimal(9.90), 3, BigDecimal(0.15))
    gamerCamila.rentalGame(gameResidentVillage, rentalPeriod1)
    gamerCamila.rentalGame(gameSpiderMan, rentalPeriod2)
    gamerCamila.rentalGame(gameTheLastOfUs, rentalPeriod3)
    gamerCamila.rentalGame(gameGodOfWar, rentalPeriod3)
//    println(gamerCamila.rentedGames)

    gamerCamila.recommend(7)
    gamerCamila.recommend(10)
    gamerCamila.recommend(11)
//    println(gamerCamila)

    gamerCamila.rentalGame(gameResidentVillage, rentalPeriod1)
//    println(gamerCamila.rentedGames)

    gamerCamila.recommendGame(gameResidentVillage, 7)
    gamerCamila.recommendGame(gameTheLastOfUs, 10)

    gamerCaroline.recommendGame(gameResidentVillage, 8)
    gamerCaroline.recommendGame(gameTheLastOfUs, 9)

    println("\nRecommended games by ${gamerCamila.name}:\n")
    println(gamerCamila.recommendedGames)
    println("\nRecommended games by ${gamerCaroline.name}:\n")
    println(gamerCaroline.recommendedGames)

    gamerCamila.recommendGame(gameResidentVillage, 7)
    gamerCamila.recommendGame(gameTheLastOfUs, 10)
    gamerCamila.recommendGame(gameAssassins, 8)
    gamerCamila.recommendGame(gameCyber, 7)
    gamerCamila.recommendGame(gameGod, 10)
    gamerCamila.recommendGame(gameDandara, 8)
    gamerCamila.recommendGame(gameSkyrim, 8)
    gamerCamila.recommendGame(gameSpiderMan, 6)

    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val serialization = gson.toJson(gamerCamila.recommendedGames)
//    println(serialization)

    val file = File("recommendedGames-${gamerCamila.name}.json")
    file.writeText(serialization)
//    println(file.absolutePath)
}