package com.conrradocamacho.alugames.data

import com.conrradocamacho.alugames.model.Rental
import com.conrradocamacho.alugames.util.toEntity
import com.conrradocamacho.alugames.util.toModel
import javax.persistence.EntityManager

class RentalDAO(manager: EntityManager): DAO<Rental, RentalEntity>(manager, RentalEntity::class.java) {
    override fun toEntity(obj: Rental): RentalEntity {
        return RentalEntity(obj.gamer.toEntity(), obj.game.toEntity(), obj.rentalPeriod)
            .apply {
                rentalValue = obj.rentalPrice.toDouble()
                id = obj.id
            }
    }

    override fun toModel(entity: RentalEntity): Rental {
        return Rental(entity.gamer.toModel(), entity.game.toModel(), entity.rentalPeriod)
            .apply {
                id = entity.id
            }
    }


}