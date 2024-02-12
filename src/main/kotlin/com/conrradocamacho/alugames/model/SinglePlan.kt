package com.conrradocamacho.alugames.model

class SinglePlan(type: String): Plan(type) {

    override fun getPrice(rental: Rental): Double {
        var originalPrice = super.getPrice(rental)
        if (rental.gamer.average > 8) {
            originalPrice -= originalPrice * 0.1
        }
        return originalPrice
    }
}
