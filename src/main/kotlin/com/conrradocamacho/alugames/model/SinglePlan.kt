package com.conrradocamacho.alugames.model

import java.math.BigDecimal

class SinglePlan(type: String, id: Int = 0): Plan(type, id) {

    override fun getPrice(rental: Rental): BigDecimal {
        var originalPrice = super.getPrice(rental)
        if (rental.gamer.average.compareTo(BigDecimal(8)) == 1) {
            originalPrice -= originalPrice.multiply(BigDecimal(0.1))
        }
        return originalPrice
    }

    override fun toString(): String {
        return "SinglePlan:\n" +
                "Type: $type\n" +
                "Id: $id\n"
    }
}
