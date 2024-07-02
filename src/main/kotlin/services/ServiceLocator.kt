package com.palmerodev.services

open class ServiceLocator {
    private val painterService: PainterService = PainterService()
    private val coliseumService: ColiseumService = ColiseumService()

    fun getColiseumService(): ColiseumService {
        return coliseumService
    }

    fun getPainterService(): PainterService {
        return painterService
    }
}