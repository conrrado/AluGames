package com.conrradocamacho.alugames.util

import com.conrradocamacho.alugames.data.GameEntity
import com.conrradocamacho.alugames.model.Game
import com.conrradocamacho.alugames.model.InfoGameJson
import java.math.BigDecimal

fun InfoGameJson.createGame(): Game {
    return Game(this.titulo, this.capa, this.preco.toBigDecimal(), this.descricao)
}

fun Game.toEntity(): GameEntity {
    return GameEntity(this.title, this.thumb, this.price.toDouble(), this.description, this.id)
}

fun GameEntity.toModel(): Game {
    return Game(
        this.title,
        this.thumb,
        BigDecimal(this.price),
        this.description,
        this.id
    )
}