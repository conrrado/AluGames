package com.conrradocamacho.alugames.model

import java.math.BigDecimal
import java.time.LocalDate
import java.time.Period

data class Rental(
    val gamer: Gamer,
    val game: Game,
    val rentalPeriod: RentalPeriod) {
    val rentalPrice: BigDecimal = gamer.plan.getPrice(this)
    var id = 0

    override fun toString(): String {
        return "Rental of ${game.title} by ${gamer.name} for the price R$ $rentalPrice"
    }
}
