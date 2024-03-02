package com.conrradocamacho.alugames.data

import com.conrradocamacho.alugames.model.RentalPeriod
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "aluguel")
class RentalEntity(
    @ManyToOne
    val gamer: GamerEntity = GamerEntity(),

    @ManyToOne
    val game: GameEntity = GameEntity(),

    @Embedded
    val rentalPeriod: RentalPeriod = RentalPeriod()
) {
    var rentalValue = 0.0

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0
}