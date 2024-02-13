package com.conrradocamacho.alugames.model

import java.math.BigDecimal

class SubscriptionPlan(
    type: String,
    val monthlyPayment: BigDecimal,
    val gamesIncluded: Int,
    val reputationDiscountPercentage: BigDecimal): Plan(type) {

    override fun getPrice(rental: Rental): BigDecimal {
        val totalGamesInTheMonth = rental.gamer.getRentedGameListByMonth(rental.rentalPeriod.initialDate.month).size + 1

        return if (totalGamesInTheMonth <= gamesIncluded) {
            BigDecimal.ZERO
        } else {
            var originalPrice = super.getPrice(rental)

            if (rental.gamer.average.compareTo(BigDecimal(8)) == 1) {
                originalPrice -= originalPrice.multiply(reputationDiscountPercentage)
            }
            return originalPrice
        }
    }

}
