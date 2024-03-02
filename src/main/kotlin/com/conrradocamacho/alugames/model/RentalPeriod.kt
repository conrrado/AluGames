package com.conrradocamacho.alugames.model

import java.time.LocalDate
import java.time.Period
import javax.persistence.Embeddable

@Embeddable
data class RentalPeriod(
    val initialDate: LocalDate = LocalDate.now(),
    val finalDate: LocalDate = LocalDate.now().plusDays(7)) {
    val inDays = Period.between(initialDate, finalDate).days
}
