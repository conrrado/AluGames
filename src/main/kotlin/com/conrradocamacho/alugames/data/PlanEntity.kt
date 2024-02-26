package com.conrradocamacho.alugames.data

import javax.persistence.*

@Entity
@Table(name = "planos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoPlano", discriminatorType = DiscriminatorType.STRING)
sealed class PlanEntity(
    open val type: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open val id: Int = 0
)

@Entity
@DiscriminatorValue("Avulso")
class SinglePlanEntity(
    type: String = "Single Plan",
    id: Int = 0
): PlanEntity(type, id)

@Entity
@DiscriminatorValue("Assinatura")
class SubscriptionPlanEntity(
    type: String = "Subscription Plan",
    val monthlyPayment: Double = 0.0,
    val gamesIncluded: Int = 0,
    val reputationDiscountPercentage: Double = 0.0,
    id: Int = 0
): PlanEntity(type, id)