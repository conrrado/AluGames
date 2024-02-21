package com.conrradocamacho.alugames.data

import javax.persistence.*

@Entity
@Table(name = "jogos")
class GameEntity(
    @Column(name = "titulo")
    val title: String = "Title of the game",

    @Column(name = "capa")
    val thumb: String = "Thumb of the game",

    @Column(name = "preco")
    val price: Double = 0.0,

    @Column(name = "descricao")
    val description: String? = null,

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0) {
}