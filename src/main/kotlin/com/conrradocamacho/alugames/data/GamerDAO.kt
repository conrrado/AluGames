package com.conrradocamacho.alugames.data

import com.conrradocamacho.alugames.model.Gamer
import javax.persistence.EntityManager

class GamerDAO(val manager: EntityManager) {

    fun getGamers(): List<Gamer> {
        val query = manager.createQuery("FROM GamerEntity", GamerEntity::class.java)
        return query.resultList.map { gamerEntity -> Gamer(
            gamerEntity.name,
            gamerEntity.email,
            gamerEntity.birthday,
            gamerEntity.user,
            gamerEntity.id
        ) }
    }

    fun addGamer(gamer: Gamer) {
        val entity = GamerEntity(gamer.name, gamer.email, gamer.birthday, gamer.user)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }
}