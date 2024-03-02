package com.conrradocamacho.alugames.main

import com.conrradocamacho.alugames.data.Database
import com.conrradocamacho.alugames.data.GameDAO
import com.conrradocamacho.alugames.data.GamerDAO
import com.conrradocamacho.alugames.data.RentalDAO
import com.conrradocamacho.alugames.model.RentalPeriod

fun main() {
    val manager = Database.getEntityManager()
    val gameDAO = GameDAO(manager)
    val gamerDAO = GamerDAO(manager)
    val rentalDAO = RentalDAO(manager)

    val gamer = gamerDAO.getById(15)
    val game = gameDAO.getById(1)
    val rental = gamer.rentalGame(game, RentalPeriod())

    rentalDAO.add(rental)

    val rentalList = rentalDAO.getList()
    println(rentalList)

    manager.close()
}