package com.conrradocamacho.alugames.util

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.birthdayToAge(): Int {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    var age = 0
    val birthday = LocalDate.parse(this, formatter)
    val today = LocalDate.now()
    age = Period.between(birthday, today).years

    return age
}