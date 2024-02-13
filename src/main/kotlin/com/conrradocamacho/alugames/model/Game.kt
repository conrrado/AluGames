package com.conrradocamacho.alugames.model

import com.google.gson.annotations.Expose
import java.math.BigDecimal
import java.math.RoundingMode

data class Game(@Expose val title: String,
           @Expose val thumb: String): Recommendable {
    var price: BigDecimal = BigDecimal.ZERO
    var description: String? = null
    private val gradeList = mutableListOf<Int>()

    override val average: BigDecimal
        get() = gradeList.takeIf { it.isNotEmpty() } ?.let { BigDecimal(it.average()) } ?: BigDecimal.ZERO

    override fun recommend(grade: Int) {
        gradeList.add(grade)
    }

    constructor(title: String, thumb: String, price: BigDecimal, description: String):
            this(title, thumb) {
                this.price = price
                this.description = description
            }

    override fun toString(): String {
        val formattedPrice = "${price.setScale(2, RoundingMode.UP)}".replace(".", ",")
        return "Game:" +
                "\nTitle: $title" +
                "\nThumb: $thumb" +
                "\nPrice: R$ $formattedPrice" +
                "\nDescription: $description" +
                "\nReputation: ${average.setScale(2, RoundingMode.UP)}"
    }
}