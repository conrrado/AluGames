package com.conrradocamacho.alugames.data

import com.conrradocamacho.alugames.model.Gamer
import javax.persistence.EntityManager

class GamerDAO(manager: EntityManager): DAO<Gamer, GamerEntity>(manager, GamerEntity::class.java) {

    override fun toEntity(obj: Gamer): GamerEntity {
        return GamerEntity(obj.name, obj.email, obj.birthday, obj.user, obj.id)
    }

    override fun toModel(entity: GamerEntity): Gamer {
        return Gamer(entity.name, entity.email, entity.birthday, entity.user, entity.id)
    }
}