package com.conrradocamacho.alugames.data

import com.conrradocamacho.alugames.model.Gamer
import com.conrradocamacho.alugames.util.toEntity
import com.conrradocamacho.alugames.util.toModel
import javax.persistence.EntityManager

class GamerDAO(manager: EntityManager): DAO<Gamer, GamerEntity>(manager, GamerEntity::class.java) {

    override fun toEntity(obj: Gamer): GamerEntity {
        return obj.toEntity()
    }

    override fun toModel(entity: GamerEntity): Gamer {
        return entity.toModel().apply {
            plan = entity.plan.toModel()
        }
    }
}