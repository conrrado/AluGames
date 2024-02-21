package com.conrradocamacho.alugames.data

import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

object Database {

//    fun getConnection(): Connection? {
//        return try {
//            DriverManager.getConnection("jdbc:mysql://localhost:3306/alugames", "root", "35Tud04Lur4@24")
//        } catch (e: SQLException) {
//            e.printStackTrace()
//            null
//        }
//    }

    fun getEntityManager(): EntityManager {
        val factory: EntityManagerFactory = Persistence.createEntityManagerFactory("alugames")
        return factory.createEntityManager()
    }
}