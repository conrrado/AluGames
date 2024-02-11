package com.conrradocamacho.alugames.model

data class Game(val title: String,
           val thumb: String) {
    var description: String? = null

    override fun toString(): String {
        return "Game:" +
                "\nTitle: $title" +
                "\nThumb: $thumb" +
                "\nDescription: $description"
    }
}