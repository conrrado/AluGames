package com.conrradocamacho.alugames.model

import java.time.LocalDate
import java.time.Month
import java.util.Scanner
import kotlin.random.Random

data class Gamer(var name: String, var email: String) {
    var birthday: String? = null
    var user: String? = null
        set(value) {
            field = value
            if (internalId.isNullOrBlank()) {
                createInternalId()
            }
        }
    var internalId: String? = null
        private set
    val gamesSearched = mutableListOf<Game?>()
    val rentedGames = mutableListOf<Rental>()

    constructor(name: String, email: String, birthday: String, user: String):
            this(name, email) {
                this.birthday = birthday
                this.user = user
                createInternalId()
            }

    init {
        if (name.isBlank()) {
            throw IllegalArgumentException("Name is blank")
        }
        this.email = validateEmail()
    }

    override fun toString(): String {
        return "Gamer(name='$name', email='$email', birthday=$birthday, user=$user, internalId=$internalId)"
    }

    private fun createInternalId() {
        val number = Random.nextInt(10000)
        val tag = String.format("%04d", number)

        internalId = "$user#$tag"
    }

    private fun validateEmail(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9._]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)) {
            return email
        }
        throw IllegalArgumentException("Email invalid")
    }

    fun rentalGame(game: Game, rentalPeriod: RentalPeriod): Rental {
        val rental = Rental(this, game, rentalPeriod)
        rentedGames.add(rental)
        return rental
    }

    fun getRentedGameListByMonth(month: Month): List<Game> {
        val rentedGameListByMonth = mutableListOf<Rental>()
        val gameListByMonth = mutableListOf<Game>()

        rentedGames.forEach {
            if (it.rentalPeriod.initialDate.month.equals(month)) {
                rentedGameListByMonth.add(it)
            }
        }

        rentedGameListByMonth.map {
            gameListByMonth.add(it.game)
        }

        return gameListByMonth
    }

    companion object {
        fun createGamer(reader: Scanner): Gamer {
            println("Welcome to AluGames! We make you register. Type your name: ")
            val name = reader.nextLine()
            println("Type your e-mail: ")
            val email = reader.nextLine()
            println("Would you like complete your register with user and birthday? (yes/no)")
            val choose = reader.nextLine()

            if (choose.equals("yes", true)) {
                println("Type your birthday (DD/MM/YYYY): ")
                val birthday = reader.nextLine()
                println("Type you user name?: ")
                val user = reader.nextLine()

                return Gamer(name, email, birthday, user)
            }
            return Gamer(name, email)
        }
    }
}
