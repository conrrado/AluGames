package com.conrradocamacho.alugames.model

import java.math.BigDecimal

class SubscriptionPlan(
    type: String,
    val monthlyPayment: BigDecimal,
    val gamesIncluded: Int,
    val reputationDiscountPercentage: BigDecimal,
    id: Int = 0): Plan(type, id) {

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

    override fun toString(): String {
        return "SubscriptionPlan\n" +
                "Type: $type\n" +
                "Id: $id\n" +
                "MonthlyPayment: $monthlyPayment\n" +
                "GamesIncluded: $gamesIncluded\n" +
                "ReputationDiscountPercentage: $reputationDiscountPercentage\n"
    }
}
