package com.conrradocamacho.alugames.model

import com.google.gson.annotations.Expose
import java.math.BigDecimal
import java.math.RoundingMode
import javax.persistence.*

data class Game(@Expose val title: String,
           @Expose val thumb: String): Recommendable {
    var price: BigDecimal = BigDecimal.ZERO
    var id = 0
    var description: String? = null
    private val gradeList = mutableListOf<Int>()

    override val average: BigDecimal
        get() = gradeList.takeIf { it.isNotEmpty() } ?.let { BigDecimal(it.average()) } ?: BigDecimal.ZERO

    override fun recommend(grade: Int) {
        gradeList.add(grade)
    }

    constructor(title: String, thumb: String, price: BigDecimal, description: String?, id: Int = 0):
            this(title, thumb) {
                this.price = price
                this.description = description
                this.id = 0
            }

    override fun toString(): String {
        val formattedPrice = "${price.setScale(2, RoundingMode.UP)}".replace(".", ",")
        return "Game:\n" +
                "Title: $title\n" +
                "Thumb: $thumb\n" +
                "Price: R$ $formattedPrice\n" +
                "Description: $description\n" +
                "Reputation: ${average.setScale(2, RoundingMode.UP)}\n" +
                "Id: $id\n"
    }
}