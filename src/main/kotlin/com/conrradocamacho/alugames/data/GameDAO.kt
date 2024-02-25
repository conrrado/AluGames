package com.conrradocamacho.alugames.data

import com.conrradocamacho.alugames.model.Game
import java.math.BigDecimal
import javax.persistence.EntityManager

class GameDAO(manager: EntityManager): DAO<Game, GameEntity>(manager, GameEntity::class.java) {

    override fun toEntity(obj: Game): GameEntity {
        return GameEntity(obj.title, obj.thumb, obj.price.toDouble(), obj.description, obj.id)
    }

    override fun toModel(entity: GameEntity): Game {
        return Game(
            entity.title,
            entity.thumb,
            BigDecimal(entity.price),
            entity.description,
            entity.id
        )
    }
}