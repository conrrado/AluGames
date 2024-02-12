package com.conrradocamacho.alugames.model

interface Recommendable {
    val average: Double

    fun recommend(grade: Int)
}