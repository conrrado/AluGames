package com.conrradocamacho.alugames.model

import java.math.BigDecimal

interface Recommendable {
    val average: BigDecimal

    fun recommend(grade: Int)
}