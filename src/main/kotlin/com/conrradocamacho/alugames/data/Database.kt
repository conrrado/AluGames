package com.conrradocamacho.alugames.data

import com.conrradocamacho.alugames.model.Game
import java.math.BigDecimal
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object Database {

    fun getConnection(): Connection? {
        return try {
            DriverManager.getConnection("jdbc:mysql://localhost:3306/alugames", "root", "35Tud04Lur4@24")
        } catch (e: SQLException) {
            e.printStackTrace()
            null
        }
    }

    fun getGames(): List<Game> {
        val gameList = mutableListOf<Game>()
        val connection = getConnection()

        if (connection != null) {
            try {
                val statement = connection.createStatement()
                val result = statement.executeQuery("SELECT * FROM jogos")

                while (result.next()) {
                    val id = result.getInt("id")
                    val title = result.getString("titulo")
                    val thumb = result.getString("capa")
                    val description = result.getString("descricao")
                    val price = result.getDouble("preco")

                    val game = Game(title, thumb, BigDecimal(price), description, id)
                    gameList.add(game)
                }

                statement.close()
            } finally {
                connection.close()
            }
        }
        return gameList
    }
}