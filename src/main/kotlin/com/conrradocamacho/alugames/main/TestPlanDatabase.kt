package com.conrradocamacho.alugames.main

import com.conrradocamacho.alugames.data.Database
import com.conrradocamacho.alugames.data.PlanDAO
import com.conrradocamacho.alugames.model.SinglePlan
import com.conrradocamacho.alugames.model.SubscriptionPlan
import java.math.BigDecimal

fun main() {
    val singlePlan = SinglePlan("BRONZE")
    val silver = SubscriptionPlan("SILVER", BigDecimal(9.98), 3, BigDecimal(0.15))
    val gold = SubscriptionPlan("GOLD", BigDecimal(19.90), 5, BigDecimal(0.20))
    val platinum = SubscriptionPlan("PLATINUM", BigDecimal(29.90), 10, BigDecimal(0.25))
    val diamond = SubscriptionPlan("DIAMOND", BigDecimal(49.90), 20, BigDecimal(0.30))

    val manager = Database.getEntityManager()
    val planDAO = PlanDAO(manager)

    planDAO.add(singlePlan)
    planDAO.add(silver)
    planDAO.add(gold)
    planDAO.add(platinum)
    planDAO.add(diamond)

    val planList = planDAO.getList()
    println(planList)

    manager.close()
}