package com.conrradocamacho.alugames.model

import java.time.LocalDate
import java.time.Period

data class Rental(
    val gamer: Gamer,
    val game: Game,
    val rentalPeriod: RentalPeriod) {
    val rentalPrice: Double = game.price * rentalPeriod.inDays

    override fun toString(): String {
        return "Rental of ${game.title} by ${gamer.name} for the price R$ $rentalPrice"
    }
}
