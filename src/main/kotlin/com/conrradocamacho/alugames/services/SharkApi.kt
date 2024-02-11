package com.conrradocamacho.alugames.services

import com.conrradocamacho.alugames.model.GameInfo
import com.conrradocamacho.alugames.model.InfoGamerJson
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class SharkApi {
    fun searchGame(id: String): GameInfo {
        val address = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(address))
            .build()
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())

        val json = response.body()

        val gson = Gson()

        val myInfoGame = gson.fromJson(json, GameInfo::class.java)

        return myInfoGame
    }

    fun searchGamer(): List<InfoGamerJson> {
        val address = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(address))
            .build()
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())

        val json = response.body()

        val gson = Gson()
        val gamerType = object : TypeToken<List<InfoGamerJson>>() {}.type
        val infoGamerList: List<InfoGamerJson> = gson.fromJson(json, gamerType)

        return infoGamerList
    }
}