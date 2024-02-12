package com.conrradocamacho.alugames.model

import java.time.LocalDate
import java.time.Period

data class RentalPeriod(
    val initialDate: LocalDate,
    val finalDate: LocalDate) {
    val inDays = Period.between(initialDate, finalDate).days
}
