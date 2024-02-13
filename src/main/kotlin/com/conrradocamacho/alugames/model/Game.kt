package com.conrradocamacho.alugames.model

import com.google.gson.annotations.Expose
import java.math.RoundingMode

data class Game(@Expose val title: String,
           @Expose val thumb: String): Recommendable {
    var price: Double = 0.0
    var description: String? = null
    private val gradeList = mutableListOf<Int>()

    override val average: Double
        get() = gradeList.average()

    override fun recommend(grade: Int) {
        gradeList.add(grade)
    }

    constructor(title: String, thumb: String, price: Double, description: String):
            this(title, thumb) {
                this.price = price
                this.description = description
            }

    override fun toString(): String {
        val formattedPrice = "${price.toBigDecimal().setScale(2, RoundingMode.UP)}".replace(".", ",")
        return "Game:" +
                "\nTitle: $title" +
                "\nThumb: $thumb" +
                "\nPrice: R$ $formattedPrice" +
                "\nDescription: $description" +
                "\nReputation: ${average.toBigDecimal().setScale(2, RoundingMode.UP)}"
    }
}