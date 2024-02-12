package com.conrradocamacho.alugames.model

class SubscriptionPlan(
    type: String,
    val monthlyPayment: Double,
    val gamesIncluded: Int): Plan(type) {

    override fun getPrice(rental: Rental): Double {
        val totalGamesInTheMonth = rental.gamer.getRentedGameListByMonth(rental.rentalPeriod.initialDate.month).size + 1

        return if (totalGamesInTheMonth <= gamesIncluded) {
            0.0
        } else {
            super.getPrice(rental)
        }
    }

}