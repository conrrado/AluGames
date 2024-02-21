package com.conrradocamacho.alugames.data

import com.conrradocamacho.alugames.model.Game
import java.math.BigDecimal

class GameDAO {

    fun getGames(): List<Game> {
        val manager = Database.getEntityManager()
        try {
            val query = manager.createQuery("FROM GameEntity", GameEntity::class.java)
            return query.resultList.map { gameEntity -> Game(
                gameEntity.title,
                gameEntity.thumb,
                BigDecimal(gameEntity.price),
                gameEntity.description,
                gameEntity.id
            ) }
        } finally {
            manager.close()
        }
    }

//    fun getGames(): List<Game> {
//        val gameList = mutableListOf<Game>()
//        val connection = Database.getConnection()
//
//        if (connection != null) {
//            try {
//                val statement = connection.createStatement()
//                val result = statement.executeQuery("SELECT * FROM jogos")
//
//                while (result.next()) {
//                    val id = result.getInt("id")
//                    val title = result.getString("titulo")
//                    val thumb = result.getString("capa")
//                    val description = result.getString("descricao")
//                    val price = result.getDouble("preco")
//
//                    val game = Game(title, thumb, BigDecimal(price), description, id)
//                    gameList.add(game)
//                }
//
//                statement.close()
//            } finally {
//                connection.close()
//            }
//        }
//        return gameList
//    }
//
//    fun addGame(game: Game) {
//        val connection = Database.getConnection()
//        val insert = "INSERT INTO jogos (TITULO, CAPA, PRECO, DESCRICAO) VALUES (?, ?, ?, ?)"
//
//        if (connection != null) {
//            try {
//                val statement = connection.prepareStatement(insert)
//                statement.setString(1, game.title)
//                statement.setString(2, game.thumb)
//                statement.setDouble(3, game.price.toDouble())
//                statement.setString(4, game.description)
//
//                statement.executeUpdate()
//                statement.close()
//
//            } finally {
//                connection.close()
//            }
//        }
//    }
}