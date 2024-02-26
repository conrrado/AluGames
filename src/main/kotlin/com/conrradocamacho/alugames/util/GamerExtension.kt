package com.conrradocamacho.alugames.util

import com.conrradocamacho.alugames.data.GamerEntity
import com.conrradocamacho.alugames.model.Gamer
import com.conrradocamacho.alugames.model.InfoGamerJson

fun InfoGamerJson.createGamer(): Gamer {
    return Gamer(this.nome, this.email, this.dataNascimento, this.usuario)
}

fun Gamer.toEntity(): GamerEntity {
    return GamerEntity(this.name, this.email, this.birthday, this.user, this.id, this.plan.toEntity())
}

fun GamerEntity.toModel(): Gamer {
    return Gamer(this.name, this.email, this.birthday, this.user, this.id)
}