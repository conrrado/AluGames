package com.conrradocamacho

import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.Scanner

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val reader = Scanner(System.`in`)
    println("Type a game code to search: ")
    val search = reader.nextLine()

    val address = "https://www.cheapshark.com/api/1.0/games?id=$search"

    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(address))
        .build()
    val response = client.send(request, BodyHandlers.ofString())

    val json = response.body()

    val gson = Gson()

    var myGame: Game? = null

    val result = runCatching {
        val myInfoGame = gson.fromJson(json, GameInfo::class.java)
        myGame = Game(myInfoGame.info.title, myInfoGame.info.thumb)
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
        println(myGame)
    }

    result.onSuccess {
        println("Busca finalizada com sucesso!")
    }
}