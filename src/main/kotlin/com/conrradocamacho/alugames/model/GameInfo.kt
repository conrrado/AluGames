package com.conrradocamacho.alugames.model

data class GameInfo(val info: InfoSharkApi) {
    override fun toString(): String {
        return info.toString()
    }
}