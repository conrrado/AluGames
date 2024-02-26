package com.conrradocamacho.alugames.data

import com.conrradocamacho.alugames.model.Plan
import com.conrradocamacho.alugames.util.toEntity
import com.conrradocamacho.alugames.util.toModel
import javax.persistence.EntityManager

class PlanDAO(manager: EntityManager): DAO<Plan, PlanEntity>(manager, PlanEntity::class.java) {
    override fun toEntity(obj: Plan): PlanEntity {
        return obj.toEntity()
    }

    override fun toModel(entity: PlanEntity): Plan {
        return entity.toModel()
    }
}