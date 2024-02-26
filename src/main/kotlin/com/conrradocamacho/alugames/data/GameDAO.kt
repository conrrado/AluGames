package com.conrradocamacho.alugames.data

import com.conrradocamacho.alugames.model.Game
import com.conrradocamacho.alugames.util.toEntity
import com.conrradocamacho.alugames.util.toModel
import javax.persistence.EntityManager

class GameDAO(manager: EntityManager): DAO<Game, GameEntity>(manager, GameEntity::class.java) {

    override fun toEntity(obj: Game): GameEntity {
        return obj.toEntity()
    }

    override fun toModel(entity: GameEntity): Game {
        return entity.toModel()
    }
}