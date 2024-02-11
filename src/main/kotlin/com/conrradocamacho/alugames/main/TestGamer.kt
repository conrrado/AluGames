package com.conrradocamacho.alugames.main

import com.conrradocamacho.alugames.model.Gamer

fun main() {
    val gamer1 = Gamer("John", "john@email.com")
    println(gamer1)

    val gamer2 = Gamer("Maria", "maria@email.com", "10/10/1990", "ursinho")
    println(gamer2)

    gamer1.let {
        it.birthday = "10/10/2000"
        it.user = "skywalker"
    }.also {
        println(gamer1.internalId)
    }

    println(gamer1)
    gamer1.user = "Test"
    println(gamer1)
}