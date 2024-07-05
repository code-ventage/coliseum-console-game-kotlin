package services

import model.FighterEntity
import java.lang.Thread.sleep

class FightService {
    private var player: FighterEntity? = null
    private val coliseum = ServiceLocator().getColiseumService()
    private val painter = ServiceLocator().getPainterService()

    private fun fight(): Boolean {
        val utils = ColiseumUtils()
        while (coliseum.getFigtherCount() > 0) {
            val enemy = coliseum.getAnEnemy()
            sleep(1000)
            while (enemy.isAlive() && player !!.isAlive()) {

                painter.displayFighters(enemy = enemy, player = player !!)
                println("Now it's your turn.")
                println("Select a number between 1 and 10.")
                val yourAttackNumber = readANumber()
                if (utils.shouldAttack(yourAttackNumber)) {
                    println("You attack ${enemy.name}.\n")
                    val yourAttack = coliseum.fight(attacker = player !!, defender = enemy)
                    if (yourAttack) {
                        println("You have defeated the ${enemy.name}!\n")
                    } else {
                        sleep(1000)
                        val enemyAttackNumber = utils.generateRandomAttackNumber(limit = 10)
                        if (enemyAttack(utils, enemyAttackNumber, enemy)) return false
                    }
                } else {
                    println("You failed to attack ${enemy.name}.")
                    sleep(1000)
                    if (enemyAttack(utils, yourAttackNumber, enemy)) return false
                }
            }
        }
        println("Congratulations, you defeated the final boss!\n")
        return true
    }

    private fun enemyAttack(utils: ColiseumUtils, enemyAttackNumber: Int, enemy: FighterEntity): Boolean {
        if (utils.shouldAttack(enemyAttackNumber)) {
            println("The ${enemy.name} has attacked you!")
            val enemyAttack = coliseum.fight(attacker = enemy, defender = player !!)
            if (enemyAttack) {
                println("The ${enemy.name} has defeated you!")
                return true
            }
        } else println("The ${enemy.name} failed to attack you.")

        return false
    }

    fun initialize() {
        println("Hello, so you want to fight?")
        sleep(1000)
        println("First, you need to pick a fighter.")
        sleep(1000)
        println("Enter the name of the fighter you want to fight.")
        sleep(1000)
        println("For example, if you want to fight the fighter named 'Pepe', you would enter 'Pepe'.")
        val fighterName = readln()
        println("Now, you need to pick a fighter.")
        sleep(1000)
        println("We have the following fighters:")
        println("1. The Warrior")
        println("2. The Mage")
        println("3. The Thief")
        var fighterNumber = readANumber()
        while (true) {
            if (fighterNumber <= 0 || fighterNumber > 3) {
                println("Please enter a number between 1 and 3.")
                fighterNumber = readANumber()
            } else break
        }
        val utils = ColiseumUtils()
        when (fighterNumber) {
            1 -> player = utils.getRandomFighter(force = 1.0)
            2 -> player = utils.getRandomFighter(force = 0.5)
            3 -> player = utils.getRandomFighter(force = 0.1)
        }

        this.player?.name = fighterName
        painter.displayFighters(player = this.player !!)

        println("\nNow, you are ready to fight.")

        coliseum.initialize()
        val result = fight()
        if (! result) {
            println("You have failed to defeat the final boss.")
        }
    }

    private fun readANumber(): Int {
        val number = readln()
        if (number.isEmpty() || number.toIntOrNull() != null) return number.toInt()

        println("Please enter a number.")
        return readANumber()

    }
}