package com.palmerodev.services

import com.palmerodev.model.*
import kotlin.random.Random

class ColiseumService {
    private val fighters: MutableList<FighterEntity> = mutableListOf()

    private fun addFighters(fighter: List<FighterEntity>) {
        fighters.addAll(fighter)
    }

    private fun desapearDeadFighters() {
        fighters.removeIf { ! it.alive }
    }

    fun fight(attacker: FighterEntity, defender: FighterEntity): Boolean {
        if (! attacker.alive || ! defender.alive) return false
        val attack = attacker.getDamage()
        defender.receiveAttack(attack)
        if (! defender.isAlive()) {
            desapearDeadFighters()
            if (defender is FinalBossEntity) fighters.clear()
            return true
        } else {
            return false
        }
    }

    private fun addFinalBoss() {
        fighters.add(
                FinalBossEntity(
                        name = "Final Boss",
                        health = Random.nextInt(100, 200),
                        alive = true,
                        magic = Random.nextInt(1, 10),
                        intelligence = Random.nextInt(1, 6),
                        strength = Random.nextInt(1, 2),
                        steal = Random.nextInt(1, 8),
                        agility = Random.nextInt(1, 7),
                )
        )
    }

    fun initialize() {
        fighters.clear()
        addFinalBoss()
        val utils = ColiseumUtils()
        val random: Int = Random.nextInt(10)
        val fightersToAdd: MutableList<FighterEntity> = mutableListOf()
        for (i in 1..random) {
            fightersToAdd.add(utils.getRandomFighter())
        }
        addFighters(fightersToAdd)
    }

    fun getFigtherCount(): Int = fighters.size

    fun getAnEnemy(): FighterEntity {
        return fighters.random()
    }

}

class ColiseumUtils {
    fun getRandomFighter(force: Double? = null): FighterEntity {
        val randomGeneratedNumber: Double = Random.nextDouble(1.0)
        return if ((force ?: randomGeneratedNumber) > 0.7) WarriorEntity(
                name = getRandomName(),
                health = Random.nextInt(100, 200),
                alive = true,
                attack = Random.nextInt(1, 10),
                strength = Random.nextInt(1, Random.nextInt(2, 15)),
        ) else if ((force ?: randomGeneratedNumber) > 0.2 && (force ?: randomGeneratedNumber) < 0.7) MagicianEntity(
                name = getRandomName(),
                health = Random.nextInt(100, 200),
                alive = true,
                magic = Random.nextInt(1, 10),
                intelligence = Random.nextInt(1, Random.nextInt(2, 15)),
        ) else ThiefEntity(
                name = getRandomName(),
                health = Random.nextInt(100, 200),
                alive = true,
                steal = Random.nextInt(1, 10),
                agility = Random.nextInt(1, Random.nextInt(2, 15)),
        )
    }

    fun shouldAttack(selected: Int, limit: Int? = null): Boolean {
        val randomGeneratedNumber = if (limit != null) Random.nextInt(limit) else Random.nextInt(10)
        println("Random Generated Number: $randomGeneratedNumber\n")
        return (if (randomGeneratedNumber - 5 >= 0) randomGeneratedNumber - 5 else 0) < selected && selected <= randomGeneratedNumber
    }

    fun generateRandomAttackNumber(limit: Int): Int = Random.nextInt(limit)

    private fun getRandomName(): String {
        val random = Random.nextInt(30)
        return when (random) {
            0 -> "Pepe"
            1 -> "Ramon"
            2 -> "Karen"
            3 -> "Juan"
            4 -> "Luis"
            5 -> "Maria"
            6 -> "Luz"
            7 -> "Maria"
            8 -> "Luz"
            9 -> "Carlos"
            10 -> "Rick Sanchez"
            11 -> "Morty"
            12 -> "Capitan Planeta"
            13 -> "Harry Potter"
            14 -> "Batman"
            15 -> "Superman"
            16 -> "Spiderman"
            17 -> "Iron Man"
            18 -> "Wonder Woman"
            19 -> "Captain America"
            20 -> "Hulk"
            21 -> "Black Widow"
            22 -> "Hawkeye"
            23 -> "Iron Fist"
            24 -> "Thor"
            25 -> "Black Panther"
            26 -> "Black Adam"
            27 -> "Star Lord"
            28 -> "Star Wars"
            29 -> "Star Trek"
            else -> "Unknown"
        }
    }
}