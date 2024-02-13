package com.conrradocamacho.alugames.model

import java.math.BigDecimal

sealed class Plan(val type: String) {

    open fun getPrice(rental: Rental): BigDecimal {
        return rental.game.price.multiply(rental.rentalPeriod.inDays.toBigDecimal())
    }
}