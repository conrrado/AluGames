package com.conrradocamacho.alugames.model

sealed class Plan(val type: String) {

    open fun getPrice(rental: Rental): Double {
        return rental.game.price * rental.rentalPeriod.inDays
    }
}