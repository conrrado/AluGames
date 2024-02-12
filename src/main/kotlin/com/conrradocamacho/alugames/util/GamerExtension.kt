package com.conrradocamacho.alugames.util

import com.conrradocamacho.alugames.model.Gamer
import com.conrradocamacho.alugames.model.InfoGamerJson

fun InfoGamerJson.createGamer(): Gamer {
    return Gamer(this.nome, this.email, this.dataNascimento, this.usuario)
}