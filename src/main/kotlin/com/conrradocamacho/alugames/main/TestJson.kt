package com.conrradocamacho.alugames.main

import com.conrradocamacho.alugames.services.SharkApi

fun main() {
    val api = SharkApi()
    val gamerList = api.searchGamer()
    println(gamerList)
}