package com.conrradocamacho.alugames.data

import javax.persistence.*

@Entity
@Table(name = "gamer")
class GamerEntity (
    @Column(name = "nome")
    val name: String= "name of the gamer",

    @Column(name = "email")
    val email: String = "email of the gamer",

    @Column(name = "aniversario")
    val birthday: String? = null,

    @Column(name = "usuario")
    val user: String? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @ManyToOne
    val plan: PlanEntity = SinglePlanEntity()
) {}