package com.conrradocamacho.alugames.util

import com.conrradocamacho.alugames.model.Game
import com.conrradocamacho.alugames.model.InfoGameJson

fun InfoGameJson.createGame(): Game {
    return Game(this.titulo, this.capa, this.preco.toBigDecimal(), this.descricao)
}