package com.conrradocamacho.alugames.util

import com.conrradocamacho.alugames.data.PlanEntity
import com.conrradocamacho.alugames.data.SinglePlanEntity
import com.conrradocamacho.alugames.data.SubscriptionPlanEntity
import com.conrradocamacho.alugames.model.Plan
import com.conrradocamacho.alugames.model.SinglePlan
import com.conrradocamacho.alugames.model.SubscriptionPlan
import java.math.BigDecimal

fun Plan.toEntity(): PlanEntity {
    return if (this is SubscriptionPlan) {
        SubscriptionPlanEntity(
            this.type,
            this.monthlyPayment.toDouble(),
            this.gamesIncluded,
            this.reputationDiscountPercentage.toDouble(),
            this.id
        )
    } else {
        SinglePlanEntity(this.type, this.id)
    }
}

fun PlanEntity.toModel(): Plan {
    return if (this is SubscriptionPlanEntity) {
        SubscriptionPlan(
            this.type,
            BigDecimal(this.monthlyPayment),
            this.gamesIncluded,
            BigDecimal(this.reputationDiscountPercentage),
            this.id
        )
    } else {
        SinglePlan(this.type, this.id)
    }
}