package com.conrradocamacho.alugames.main

import com.conrradocamacho.alugames.model.RentalPeriod
import com.conrradocamacho.alugames.model.SubscriptionPlan
import com.conrradocamacho.alugames.services.ConsumeApi
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
//    println(gamerCaroline.rentedGames)

//    println(gamerCaroline.getRentedGameListByMonth(LocalDate.now().month + 1))

    val gamerCamila = gamerList.get(5)
    gamerCamila.plan = SubscriptionPlan("SILVER", 9.90, 3, 0.15)
    gamerCamila.rentalGame(gameResidentVillage, rentalPeriod1)
    gamerCamila.rentalGame(gameSpiderMan, rentalPeriod2)
    gamerCamila.rentalGame(gameTheLastOfUs, rentalPeriod3)
    gamerCamila.rentalGame(gameGodOfWar, rentalPeriod3)
    println(gamerCamila.rentedGames)

    gamerCamila.recommend(7)
    gamerCamila.recommend(10)
    gamerCamila.recommend(11)
    println(gamerCamila)

    gamerCamila.rentalGame(gameResidentVillage, rentalPeriod1)
    println(gamerCamila.rentedGames)
}