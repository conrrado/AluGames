package com.conrradocamacho.alugames.services

import com.conrradocamacho.alugames.model.*
import com.conrradocamacho.alugames.util.createGame
import com.conrradocamacho.alugames.util.createGamer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumeApi {

    private fun consumeData(address: String): String {
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(address))
            .build()
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())

        return response.body()
    }

    fun searchGameById(id: String): GameInfo {
        val address = "https://www.cheapshark.com/api/1.0/games?id=$id"
        val json = consumeData(address)

        val gson = Gson()
        val myInfoGame = gson.fromJson(json, GameInfo::class.java)

        return myInfoGame
    }

    fun getGamerList(): List<Gamer> {
        val address = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        val json = consumeData(address)

        val gson = Gson()
        val gamerType = object : TypeToken<List<InfoGamerJson>>() {}.type
        val infoGamerList: List<InfoGamerJson> = gson.fromJson(json, gamerType)

        val gamerListConverted = infoGamerList.map { infoGamerJson -> infoGamerJson.createGamer() }

        return gamerListConverted
    }

    fun getGameList(): List<Game> {
        val address = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        val json = consumeData(address)

        val gson = Gson()
        val gameType = object : TypeToken<List<InfoGameJson>>() {}.type
        val infoGameList: List<InfoGameJson> = gson.fromJson(json, gameType)

        val gameListConverted = infoGameList.map { infoGameJson -> infoGameJson.createGame() }

        return gameListConverted
    }
}