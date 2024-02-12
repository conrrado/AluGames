package com.conrradocamacho.alugames.model

data class Game(val title: String,
           val thumb: String) {
    var price: Double = 0.0
    var description: String? = null

    override fun toString(): String {
        return "Game:" +
                "\nTitle: $title" +
                "\nThumb: $thumb" +
                "\nPrice: $price" +
                "\nDescription: $description"
    }

    constructor(title: String, thumb: String, price: Double, description: String):
            this(title, thumb) {
                this.price = price
                this.description = description
            }
}