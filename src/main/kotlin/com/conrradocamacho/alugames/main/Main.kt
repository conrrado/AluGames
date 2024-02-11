package com.conrradocamacho.alugames.main

import com.conrradocamacho.alugames.services.SharkApi
import com.conrradocamacho.alugames.model.Game
import com.conrradocamacho.alugames.model.Gamer
import com.conrradocamacho.alugames.util.birthdayToAge
import java.util.*

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val reader = Scanner(System.`in`)
    val gamer = Gamer.createGamer(reader)
    println("Registration completed successfully! Gamer's data: ")
    println(gamer)
    println("Games Age: " + gamer.birthday?.birthdayToAge())

    do {
        println("Type a game code to search: ")
        val search = reader.nextLine()

        var myGame: Game? = null

        val result = runCatching {
            val searchApi = SharkApi()
            val gameInfo = searchApi.searchGame(search)

            myGame = Game(gameInfo.info.title, gameInfo.info.thumb)
        }

        result.onFailure {
            println("Ops, game not exist, try another id")
        }

        result.onSuccess {
            println("Would you type a custom description? yes/no")
            val option = reader.nextLine()
            if (option.equals("yes", true)) {
                println("Type the custom description for the game: ")
                val customDescription = reader.nextLine()
                myGame?.description = customDescription
            } else {
                myGame?.description = myGame?.title
            }

            gamer.gamesSearched.add(myGame)
        }

        println("Would you want search a new game? yes/no")
        val answer = reader.nextLine()
    } while (answer.equals("yes", true))

    println("Games searched:")
    println(gamer.gamesSearched)

    println("\nGames ordered by title: ")
    gamer.gamesSearched.sortBy {
        it?.title
    }

    gamer.gamesSearched.forEach {
        println("Title: " + it?.title)
    }

    val gamesFiltered = gamer.gamesSearched.filter {
        it?.title?.contains("batman", true) ?: false
    }
    println("\nGames filtered: ")
    println(gamesFiltered)

    println("Would you like remove any game of the list? (yes/no)")
    val chooseRemove = reader.nextLine()
    if (chooseRemove.equals("yes", true)) {
        println(gamer.gamesSearched)
        println("\nType the game position:")
        val position = reader.nextInt()
        gamer.gamesSearched.removeAt(position)
    }

    println("\nList updated")
    println(gamer.gamesSearched)

    println("Busca finalizada com sucesso!")
}