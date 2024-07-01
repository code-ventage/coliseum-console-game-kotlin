package com.palmerodev.services

import com.palmerodev.model.MagicianEntity
import com.palmerodev.model.WarriorEntity

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