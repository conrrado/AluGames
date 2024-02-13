package com.conrradocamacho.alugames.model

import java.math.BigDecimal
import java.math.RoundingMode
import java.time.LocalDate
import java.time.Month
import java.util.Scanner
import kotlin.random.Random

data class Gamer(var name: String, var email: String): Recommendable {
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
    var plan: Plan = SinglePlan("BRONZE")
    val gamesSearched = mutableListOf<Game?>()
    val rentedGames = mutableListOf<Rental>()
    private val gradeList = mutableListOf<Int>()
    val recommendedGames = mutableListOf<Game>()

    override val average: BigDecimal
        get() = gradeList.takeIf { it.isNotEmpty() } ?.let { BigDecimal(it.average()) } ?: BigDecimal.ZERO

    override fun recommend(grade: Int) {
        if (grade in 1..10) {
            gradeList.add(grade)
        } else {
            println("The grade value $grade not added, the value needed between 1 and 10")
        }
    }

    fun recommendGame(game: Game, grade: Int) {
        game.recommend(grade)
        recommendedGames.add(game)
    }

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
        return "Gamer:\n" +
                "Name: $name\n" +
                "Email: $email\n" +
                "Birthday: $birthday\n" +
                "User: $user\n" +
                "InternalId: $internalId\n" +
                "Reputation: ${average.setScale(2, RoundingMode.UP)}"
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
        return rentedGames
            .filter { rental -> rental.rentalPeriod.initialDate.month.equals(month) }
            .map { rental -> rental.game }
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
