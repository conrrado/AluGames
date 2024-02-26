package com.conrradocamacho.alugames.main

import com.conrradocamacho.alugames.data.Database
import com.conrradocamacho.alugames.data.GamerDAO
import com.conrradocamacho.alugames.data.PlanDAO
import com.conrradocamacho.alugames.model.Gamer

fun main() {
    val gamer = Gamer("Monica", "monica@email.com", "15/03/2001", "mona")

    val manager = Database.getEntityManager()
    val gamerDAO = GamerDAO(manager)
    val planDAO = PlanDAO(manager)

    gamer.plan = planDAO.getById(3)

    gamerDAO.add(gamer)

    val gamerList = gamerDAO.getList()
    println(gamerList)

    manager.close()
}