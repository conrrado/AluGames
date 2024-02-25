package com.conrradocamacho.alugames.data

import com.conrradocamacho.alugames.model.Plan
import com.conrradocamacho.alugames.model.SinglePlan
import com.conrradocamacho.alugames.model.SubscriptionPlan
import java.math.BigDecimal
import javax.persistence.EntityManager

class PlanDAO(manager: EntityManager): DAO<Plan, PlanEntity>(manager, PlanEntity::class.java) {
    override fun toEntity(obj: Plan): PlanEntity {
        return if (obj is SubscriptionPlan) {
            SubscriptionPlanEntity(
                obj.type,
                obj.monthlyPayment.toDouble(),
                obj.gamesIncluded,
                obj.reputationDiscountPercentage.toDouble(),
                obj.id
            )
        } else {
            SinglePlanEntity(obj.type, obj.id)
        }
    }

    override fun toModel(entity: PlanEntity): Plan {
        return if (entity is SubscriptionPlanEntity) {
            SubscriptionPlan(
                entity.type,
                BigDecimal(entity.monthlyPayment),
                entity.gamesIncluded,
                BigDecimal(entity.reputationDiscountPercentage),
                entity.id
            )
        } else {
            SinglePlan(entity.type, entity.id)
        }
    }
}