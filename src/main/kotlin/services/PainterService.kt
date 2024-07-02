package com.palmerodev.services

import com.palmerodev.model.FighterEntity

open class PainterService {

    fun displayFighters(enemy: FighterEntity? = null, player: FighterEntity) {

        if (enemy != null) {
            println("${getPadding() +  "Name: " +  enemy.name} \n ${getPadding() + getHealthBar(enemy.health)}")
            drawCharacter('E', enemy.getDamage())
        }

        println("\nName: ${player.name} \n${getHealthBar(player.health)}")
        drawCharacter('A', player.getDamage())

    }

    private fun getHealthBar(health: Int): String {
        val healthBar = StringBuilder()
        for (i in 1 .. health / 10 ) {
            healthBar.append("█")
        }
        return "HP: $healthBar :: $health"
    }

    private fun drawCharacter(character: Char, damage: Int) {
        val padding = getPadding()
        if (character == 'E') {
            println("$padding DMG: $damage")
            println("$padding  _____")
            println("$padding ( ~ ~ )")
            println("$padding // || \\\\ ")
            println("$padding || ||  ||")
            println("$padding   _||_  ")
            println("$padding  ||  || ")
        } else {
            println("DMG: $damage")
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