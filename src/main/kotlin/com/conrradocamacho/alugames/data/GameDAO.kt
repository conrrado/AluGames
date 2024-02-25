package com.conrradocamacho.alugames.data

import com.conrradocamacho.alugames.model.Game
import java.math.BigDecimal
import javax.persistence.EntityManager

class GameDAO(val manager: EntityManager) {

    fun getGames(): List<Game> {
        val query = manager.createQuery("FROM GameEntity", GameEntity::class.java)
        return query.resultList.map { gameEntity -> Game(
            gameEntity.title,
            gameEntity.thumb,
            BigDecimal(gameEntity.price),
            gameEntity.description,
            gameEntity.id
        ) }
    }

    fun addGame(game: Game) {
        val entity = GameEntity(game.title, game.thumb, game.price.toDouble(), game.description)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }
}