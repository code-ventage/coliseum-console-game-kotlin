package com.palmerodev.services

import com.palmerodev.model.FighterEntity
import com.palmerodev.model.WarriorEntity

open class PainterService {

    fun displayFighters(enemy: FighterEntity, attacker: FighterEntity) {

        println("${getPadding() + attacker.name} \n ${getPadding() +getHealthBar(attacker.health)}")
        drawCharacter('E', "Enemigo")

        println("${  enemy.name} \n ${getHealthBar(enemy.health)}")
        drawCharacter('A', "Atacante")
    }

    private fun getHealthBar(health: Int): String {
        val healthBar = StringBuilder()
        for (i in 1 .. health / 100 ) {
            healthBar.append("█")
        }
        return healthBar.toString()
    }

    private fun drawCharacter(character: Char, label: String) {
        val padding = getPadding()
        if (character == 'E') {
            println("$padding  _____")
            println("$padding ( ~ ~ )")
            println("$padding // || \\\\ ")
            println("$padding || ||  ||")
            println("$padding   _||_  ")
            println("$padding  ||  || ")
        } else {
            println(" ^^^^^")
            println("( - - )")
            println(" / | \\")
            println(" | |  |")
            println("  _|_  ")
            println(" |   | ")
        }
    }

    private fun getPadding(): String {
        var padding = ""
        for (i in 1 .. 12) {
            padding += "\t"
        }
        return padding
    }


}

fun main() {
    val painterService = PainterService()
    val you = WarriorEntity("Enemy", 100, attack = 12, alive = true, health = 2000)
    val enemy = WarriorEntity("You", 100, attack = 12, alive = true, health = 2000)
    painterService.displayFighters(enemy, you)
}